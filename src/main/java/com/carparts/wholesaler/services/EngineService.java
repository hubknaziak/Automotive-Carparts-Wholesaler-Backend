package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.Engine;
import com.carparts.wholesaler.repositories.EngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final EngineRepository engineRepository;

    public List<Engine> getEnginesForCarModel(int idModel, int idGeneration){return engineRepository.findAllByModel_id(idModel, idGeneration);}
}
