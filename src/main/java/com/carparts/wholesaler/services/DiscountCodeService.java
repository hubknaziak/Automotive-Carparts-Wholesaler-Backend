package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.DiscountCode;
import com.carparts.wholesaler.repositories.DiscountCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCode addDiscountCode(String code, double value){
        DiscountCode discountCode = new DiscountCode();
        discountCode.setCode(code);
        discountCode.setValue(value);

        return discountCodeRepository.save(discountCode);
    }

    public void deleteDiscountCode(String code){
        discountCodeRepository.deleteDiscountCode(code);
    }
}
