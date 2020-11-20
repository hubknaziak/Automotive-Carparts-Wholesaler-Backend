package com.carparts.wholesaler.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonalDataDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String street;
    private int houseNumber;
    private int apartmentNumber;
    private String postcode;
    private String city;
    private String country;
}
