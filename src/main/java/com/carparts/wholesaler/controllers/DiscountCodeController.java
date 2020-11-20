package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.models.DiscountCode;
import com.carparts.wholesaler.services.DiscountCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    @CrossOrigin
    @PostMapping("addDiscountCode")
    public DiscountCode addDiscountCode(@RequestParam String code, @RequestParam double value){
        return discountCodeService.addDiscountCode(code, value);
    }

    @CrossOrigin
    @DeleteMapping("deleteDiscountCode")
    public void deleteDiscountCode(@RequestParam String code){
        discountCodeService.deleteDiscountCode(code);
    }
}
