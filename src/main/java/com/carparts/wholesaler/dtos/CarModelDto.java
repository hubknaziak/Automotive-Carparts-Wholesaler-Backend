package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CarModelDto {

    private int idModel;
    private String name;
    private String body;

}
