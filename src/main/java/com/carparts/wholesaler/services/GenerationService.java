package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.Generation;
import com.carparts.wholesaler.repositories.GenerationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenerationService {

    private final GenerationRepository generationRepository;

    public List<Generation> getAllGenerations(int idModel){ return generationRepository.findAllByModel_id(idModel);}
}
