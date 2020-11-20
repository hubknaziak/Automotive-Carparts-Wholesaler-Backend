package com.carparts.wholesaler.mappers;

import com.carparts.wholesaler.dtos.EngineDto;
import com.carparts.wholesaler.models.Engine;

import java.util.List;
import java.util.stream.Collectors;

public class EngineMapper {

    private EngineMapper(){

    }

    public static List<EngineDto> mapToEngineDtos(List<Engine> engines){
        return engines.stream()
                .map(engine -> mapToEngineDto(engine))
                .collect(Collectors.toList());
    }

    private static EngineDto mapToEngineDto(Engine engine){
        return EngineDto.builder()
                .idEngine(engine.getIdEngine())
                .name(engine.getName())
                .code(engine.getCode())
                .fuel(engine.getFuel())
                .yearsOfProduction(engine.getYearsOfProduction())
                .capacity(engine.getCapacity())
                .power(engine.getPower())
                .torque(engine.getTorque())
                .build();
    }
}
