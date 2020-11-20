package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM accounts WHERE Id_account = (SELECT MAX(Id_account) FROM accounts)", nativeQuery = true)
    Account findByMaxId();

    //@Query(value = "SELECT * FROM accounts WHERE Id_account = (SELECT MAX(Id_account) FROM accounts)")
    Account findByEmail(String email);
}
