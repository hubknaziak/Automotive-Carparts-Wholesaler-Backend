package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartTypeDto {

    private int idPartType;
    private String name;
}
