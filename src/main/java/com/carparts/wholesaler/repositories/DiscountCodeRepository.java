package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.DiscountCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Integer> {

    DiscountCode findByCode (String code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM discount_codes WHERE code = :code", nativeQuery = true)
    void deleteDiscountCode(@Param("code") String code);
}
