package com.carparts.wholesaler.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartDto {

    private String partTypeName;
    private String name;
    private String oe;
    private String producer;
    private String producerCode;
    private double netPrice;
    private double grossPrice;
    private int quantity;
    private String information;
    private String engineCodes;
    private String modelNames;
    private String generationNames;
}
