package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.models.Payment;
import com.carparts.wholesaler.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @CrossOrigin
    @GetMapping("getPaymentByIdClient/{idClient}")
    public Payment getPaymentByIdClient(@PathVariable int idClient){
        return paymentService.getPaymentByIdClient(idClient);
    }

    @CrossOrigin
    @GetMapping("getAllPayments")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @CrossOrigin
    @PutMapping("putDiscountCode")
    public Payment putDiscountCode(@RequestParam String code, @RequestParam int idPayment){
        return paymentService.putDiscountCode(code, idPayment);
    }

    @CrossOrigin
    @PutMapping("confirmPayment")
    public Payment confirmPayment(@RequestParam String payMethod, @RequestParam int idPayment){
        return paymentService.confirmPayment(payMethod, idPayment);
    }

    @CrossOrigin
    @PutMapping("confirmOrder/{paymentId}")
    public Payment confirmOrder(@PathVariable int paymentId){
        return paymentService.confirmOrder(paymentId);
    }

    @CrossOrigin
    @DeleteMapping("deletePayment")
    public void deletePayment(@RequestParam int idPayment){
        paymentService.deletePayment(idPayment);
    }
}
