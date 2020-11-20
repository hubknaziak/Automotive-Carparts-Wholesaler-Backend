package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    @Query(
            value = "SELECT * FROM car_models m WHERE m.make_id = :idMake",
            nativeQuery = true)
    List<CarModel> findAllByMake_id(@Param("idMake") int idMake);

    List<CarModel> findByName(String name);
}
