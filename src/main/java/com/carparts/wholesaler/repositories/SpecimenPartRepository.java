package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.SpecimenPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SpecimenPartRepository extends JpaRepository<SpecimenPart, Integer> {

    List<SpecimenPart> findByOe(String oe);

    List<SpecimenPart> findByProducerCode(String producerCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM specimen_parts WHERE Id_specimen_part = :idSpecimenPart", nativeQuery = true)
    void deleteSpecimenPart(@Param("idSpecimenPart") int idSpecimenPart);

//    @Query(value = "SELECT * FROM specimen_parts  WHERE Id_specimen_part = :idSpecimenPart", nativeQuery = true)
//    SpecimenPart findById(@Param("idSpecimenPart")int idSpecimenPart);
}
