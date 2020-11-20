package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.*;
import com.carparts.wholesaler.repositories.ClientRepository;
import com.carparts.wholesaler.repositories.DetailPaymentRepository;
import com.carparts.wholesaler.repositories.PaymentRepository;
import com.carparts.wholesaler.repositories.SpecimenPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailPaymentService {

    private final DetailPaymentRepository detailPaymentRepository;
    private final SpecimenPartRepository specimenPartRepository;
    private final ClientRepository clientRepository;
    private final PaymentRepository paymentRepository;

    public DetailPayment addDetailPayment(int idSpecimenPart, int idClient, int quantity) throws IllegalArgumentException{

       Optional<SpecimenPart> specimenPart = specimenPartRepository.findById(idSpecimenPart);
       Optional<Client> client = clientRepository.findById(idClient);
       List<Payment> payments = paymentRepository.findAllByClientId(idClient);
       Payment payment = new Payment();
       DetailPayment detailPayment = new DetailPayment();

       boolean paymentExists = false;
        for (Payment p : payments) {
            if(p.getStatus().equals("waiting to confirm")){  //wyszukanie payment do ktorego dodawane sa zakupy
                payment = p;
                paymentExists = true;
            }
        }

       if(!paymentExists){ //jezeli klient nie dokonywal zakupow, lub dokonuje nowego zakupu
           //utworz nowy zakup
           payment.setClient(client.get());
           payment.setTotalCost(0);
           payment.setStatus("waiting to confirm");
           payment.setPaymentMethod("not defined");
           payment.setPaymentStatus("not defined");
           payment.setDiscountCode(client.get().getDiscountCode());

           paymentRepository.save(payment); //zapisujemy nowe payment
           Payment idPayment = paymentRepository.findByMaxId(); //pobieramy idPayment o maksymalnym ID (nowe zapisane)
           //tworzymy nowy detailPayment
           detailPayment.setPayment(idPayment);
           detailPayment.setSpecimenPart(specimenPart.get());
           detailPayment.setQuantity(quantity);
           if(client.get().getType().equals("company")) detailPayment.setCost(specimenPart.get().getNetPrice());
           else detailPayment.setCost(specimenPart.get().getGrossPrice());

           DiscountCode discountCode = client.get().getDiscountCode(); //pobieramy znizke klienta
           if(discountCode != null) idPayment.setTotalCost(detailPayment.getCost() * discountCode.getValue()); //nadpisujemy koszt ogolny
           else  idPayment.setTotalCost(detailPayment.getCost()); //nadpisujemy koszt ogolny

           paymentRepository.save(idPayment);   //zapisujemy dane o zakupach
           detailPaymentRepository.save(detailPayment);
       }
       else{ //jezeli klient dorzuca czesci do koszyka
           detailPayment.setPayment(payment);
           detailPayment.setSpecimenPart(specimenPart.get());
           detailPayment.setQuantity(quantity);
           if(client.get().getType().equals("company")) detailPayment.setCost(specimenPart.get().getNetPrice());
           else detailPayment.setCost(specimenPart.get().getGrossPrice());

           double totalCost = payment.getTotalCost() + detailPayment.getCost();
           payment.setTotalCost(totalCost);

           paymentRepository.save(payment);
           detailPaymentRepository.save(detailPayment);
       }
       return detailPayment;
    }

    public void deleteDetailPayment(int idDetailPayment){
        detailPaymentRepository.deleteById(idDetailPayment);
    }
}
