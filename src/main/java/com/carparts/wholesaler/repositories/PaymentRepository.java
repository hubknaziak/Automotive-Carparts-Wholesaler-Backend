package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.CarModel;
import com.carparts.wholesaler.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(
            value = "SELECT * FROM payments p WHERE p.client = :idClient",
            nativeQuery = true)
    List<Payment> findAllByClientId(@Param("idClient") int idClient);

    @Query(
            value = "SELECT * FROM payments p WHERE p.client = :idClient AND p.status = 'waiting to confirm' OR p.status = 'in progress'",
            nativeQuery = true)
    Payment findByClientId(@Param("idClient") int idClient);

    @Query(value = "SELECT * FROM payments WHERE Id_Payment = (SELECT MAX(Id_Payment) FROM payments)", nativeQuery = true)
    Payment findByMaxId();

//    @Modifying
//    @Query(value = "DELETE payments, detail_payments FROM payments INNER JOIN detail_payments WHERE payments.Id_Payment = :Id_Payment AND payments.Id_Payment = detail_payments.payment_id", nativeQuery = true)
//    void deleteById(@Param("Id_Payment")int Id_Payment);

    @Modifying
    @Query(value = "DELETE FROM payments WHERE Id_Payment = :Id_Payment ", nativeQuery = true)
    void deleteById(@Param("Id_Payment")int Id_Payment);

    List<Payment> findAllByStatus(String status);
}