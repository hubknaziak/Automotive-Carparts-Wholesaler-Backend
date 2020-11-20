package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.DetailPayment;
import com.carparts.wholesaler.models.Payment;
import com.carparts.wholesaler.models.SpecimenPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailPaymentRepository extends JpaRepository<DetailPayment, Integer> {

    @Query(value = "SELECT * FROM detail_payments  WHERE id_detail_payment = :id_detail_payment", nativeQuery = true)
    DetailPayment findById(@Param("id_detail_payment")int id_detail_payment);

    @Query(value = "SELECT * FROM detail_payments  WHERE payment_id = :payment", nativeQuery = true)
    List<DetailPayment> findAllByPayment(int payment);

    @Modifying
    @Query(value = "DELETE FROM detail_payments  WHERE id_detail_payment = :id_detail_payment", nativeQuery = true)
    void deleteById(@Param("id_detail_payment")int id_detail_payment);
}
