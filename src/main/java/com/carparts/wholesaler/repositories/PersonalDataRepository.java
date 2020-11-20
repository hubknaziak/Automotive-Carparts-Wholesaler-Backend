package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Integer> {

    @Query(value = "SELECT * FROM personal_datas WHERE Id_personal_data = (SELECT MAX(Id_personal_data) FROM personal_datas)", nativeQuery = true)
    PersonalData findByMaxId();
}
