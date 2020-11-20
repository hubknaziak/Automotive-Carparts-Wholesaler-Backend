package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EngineRepository extends JpaRepository<Engine, Integer> {

    @Query(
            value = "SELECT * FROM engines e JOIN car_model_engine me ON e.id_engine = me.engine_id WHERE me.car_model_id = :idModel AND e.generation = :idGeneration ORDER BY e.capacity ASC",
            //value = "SELECT * FROM engines e WHERE e.generation = :idGeneration AND e.generation = :idModel",
            nativeQuery = true
    )
    List<Engine> findAllByModel_id(@Param("idModel")int idModel, @Param("idGeneration") int idGeneration);

    Engine findByCode(String code);
}
