package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EngineDto {

    private int idEngine;
    private String name;
    private String code;
    private String fuel;
    private String yearsOfProduction;
    private double capacity;
    private double power;
    private double torque;
}
