package com.carparts.wholesaler.repositories;

import com.carparts.wholesaler.models.Generation;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GenerationRepository extends JpaRepository<Generation, Integer> {

    @Query(
            value = "SELECT * from generations g WHERE g.model_id = :idModel ORDER BY g.begin_date ASC",
            nativeQuery = true)
    List<Generation> findAllByModel_id(@Param("idModel") int idModel);

    Generation findByName(String name);
}
