package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.EngineDto;
import com.carparts.wholesaler.mappers.EngineMapper;
import com.carparts.wholesaler.models.Engine;
import com.carparts.wholesaler.services.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;

    @CrossOrigin
    @GetMapping("getEnginesFitsToModel/{idModel}/{idGeneration}")
    public List<EngineDto> getEnginesForCarModel(@PathVariable int idModel, @PathVariable int idGeneration){
        return EngineMapper.mapToEngineDtos(engineService.getEnginesForCarModel(idModel, idGeneration));
    }
}
