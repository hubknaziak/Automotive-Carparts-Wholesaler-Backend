package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.GenerationDto;
import com.carparts.wholesaler.mappers.GenerationMapper;
import com.carparts.wholesaler.services.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenerationController {

    private final GenerationService generationService;

    @CrossOrigin
    @GetMapping("getAllGenerations/{model_id}")
    public List<GenerationDto> getGenerations(@PathVariable int model_id){
        return GenerationMapper.mapToGenerationDtos(generationService.getAllGenerations(model_id));
    }
}
