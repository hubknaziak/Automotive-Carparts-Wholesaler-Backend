package com.carparts.wholesaler.mappers;

import com.carparts.wholesaler.dtos.CarMakeDto;
import com.carparts.wholesaler.dtos.PartTypeDto;
import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.models.PartType;

import java.util.List;
import java.util.stream.Collectors;

public class PartTypeMapper {

    private PartTypeMapper(){

    }

    public static List<PartTypeDto> mapToPartTypeDtos(List<PartType> partTypes) {
        return partTypes.stream()
                .map(partType -> mapToPartTypeDto(partType))
                .collect(Collectors.toList());
    }

    private static PartTypeDto mapToPartTypeDto(PartType partType) {
        return PartTypeDto.builder()
                .idPartType(partType.getIdPartType())
                .name(partType.getName())
                .build();
    }
}
