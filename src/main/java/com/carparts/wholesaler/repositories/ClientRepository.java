package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByNip(long nip);
}
