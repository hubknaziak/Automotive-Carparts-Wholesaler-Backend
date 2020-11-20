package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class CarMakeDto {

    private int idMake;
    private String name;
    private String country;

}
