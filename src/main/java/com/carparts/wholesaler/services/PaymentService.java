package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.DetailPayment;
import com.carparts.wholesaler.models.DiscountCode;
import com.carparts.wholesaler.models.Payment;
import com.carparts.wholesaler.repositories.DetailPaymentRepository;
import com.carparts.wholesaler.repositories.DiscountCodeRepository;
import com.carparts.wholesaler.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final DiscountCodeRepository discountCodeRepository;
    private final DetailPaymentRepository detailPaymentRepository;

    public Payment getPaymentByIdClient(int idClient){

        return paymentRepository.findByClientId(idClient);
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment putDiscountCode(String code, int idPayment){
        DiscountCode discountCode = discountCodeRepository.findByCode(code);
        if(discountCode == null){
            return null;
        }
        Optional<Payment> payment = paymentRepository.findById(idPayment);
        payment.get().setDiscountCode(discountCode);
        paymentRepository.save(payment.get());
        return  payment.get();
    }

    public Payment confirmPayment(String payMethod, int idPayment){
        Optional<Payment> payment = paymentRepository.findById(idPayment);
        if(payMethod.equals("cash")){
            payment.get().setPaymentMethod("cash");
            payment.get().setPaymentStatus("payed");
            payment.get().setStatus("in progress");
            paymentRepository.save(payment.get());
        }
        else if(payMethod.equals("transfer")){
            payment.get().setPaymentMethod("transfer");
            payment.get().setPaymentStatus("waiting");
            payment.get().setStatus("in progress");
            paymentRepository.save(payment.get());
        }
        return  payment.get();
    }

    public Payment confirmOrder(int paymentId){
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        payment.get().setPaymentStatus("payed");
        payment.get().setStatus("completed");

        return paymentRepository.save(payment.get());
    }

    public void deletePayment(int idPayment){

        List<DetailPayment> detailPaymentList = detailPaymentRepository.findAllByPayment(idPayment);
        for(DetailPayment detailPayment : detailPaymentList){
            detailPaymentRepository.deleteById(detailPayment.getIdDetailPayment()); //znalezienie i usuniecie powiazanych detail payment
        }
        paymentRepository.deleteById(idPayment); //usuniecie detail payment
    }
}
