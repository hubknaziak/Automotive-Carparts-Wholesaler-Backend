package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Engine;
import com.carparts.wholesaler.models.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

    @Query(
            value = "SELECT * FROM parts p JOIN car_model_part mp ON p.id_part = mp.part_id JOIN engine_part ep ON p.id_part = ep.part_id " +
                    "WHERE p.part_type_id = :idPartType AND mp.car_model_id = :idModel AND ep.engine_id = :idEngine ORDER BY p.name ASC",
            nativeQuery = true
    )
    List<Part> findPartsByParams(@Param("idModel")int idModel, @Param("idEngine") int idEngine, @Param("idPartType") int idPartType);

}
