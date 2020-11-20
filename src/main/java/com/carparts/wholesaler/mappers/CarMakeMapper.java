package com.carparts.wholesaler.mappers;

import com.carparts.wholesaler.dtos.CarMakeDto;
import com.carparts.wholesaler.models.CarMake;

import java.util.List;
import java.util.stream.Collectors;

public class CarMakeMapper {

    private CarMakeMapper(){

    }

    public static List<CarMakeDto> mapToCarMakeDtos(List<CarMake> carMakes) {
        return carMakes.stream()
                .map(carMake -> mapToCarMakeDto(carMake))
                .collect(Collectors.toList());
    }

    private static CarMakeDto mapToCarMakeDto(CarMake carMake) {
        return CarMakeDto.builder()
                .idMake(carMake.getIdMake())
                .name(carMake.getName())
                .country(carMake.getCountry())
                .build();
    }
}
