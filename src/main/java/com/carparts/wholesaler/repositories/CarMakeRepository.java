package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.CarMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMakeRepository extends JpaRepository<CarMake, Integer> {

}
