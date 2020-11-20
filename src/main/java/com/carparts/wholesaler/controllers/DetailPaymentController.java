package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.models.DetailPayment;
import com.carparts.wholesaler.services.DetailPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DetailPaymentController {

    private final DetailPaymentService detailPaymentService;

    @CrossOrigin
    @PostMapping("addDetailPayment")
    public DetailPayment addDetailPayment(@RequestParam int idSpecimenPart, @RequestParam int idClient, @RequestParam int quantity){
        return detailPaymentService.addDetailPayment(idSpecimenPart, idClient, quantity);
    }

    @CrossOrigin
    @DeleteMapping("deleteDetailPayment/{idDetailPayment}")
    public void deleteDetailPayment(@PathVariable int idDetailPayment){
        detailPaymentService.deleteDetailPayment(idDetailPayment);
    }
}
