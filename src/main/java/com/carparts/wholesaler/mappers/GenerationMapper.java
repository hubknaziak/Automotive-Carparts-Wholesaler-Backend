package com.carparts.wholesaler.mappers;

import com.carparts.wholesaler.dtos.GenerationDto;
import com.carparts.wholesaler.models.Generation;

import java.util.List;
import java.util.stream.Collectors;

public class GenerationMapper {

    private GenerationMapper(){

    }

    public static List<GenerationDto> mapToGenerationDtos(List<Generation> generations){
        return generations.stream()
                .map(generation -> mapToGenerationDto(generation))
                .collect(Collectors.toList());

    }

    public static GenerationDto mapToGenerationDto(Generation generation){
        return GenerationDto.builder()
                .idGeneration(generation.getIdGeneration())
                .beginDate(generation.getBeginDate())
                .endDate(generation.getEndDate())
                .name(generation.getName())
                .build();
    }
}
