package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.PartType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartTypeRepository extends JpaRepository<PartType, Integer> {

    PartType findByName(String name);
}
