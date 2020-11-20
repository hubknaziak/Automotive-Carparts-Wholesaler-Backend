package com.carparts.wholesaler.mappers;

import com.carparts.wholesaler.dtos.CarModelDto;
import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.models.CarModel;

import java.util.List;
import java.util.stream.Collectors;

public class CarModelMapper {

    private CarModelMapper(){

    }

    public static List<CarModelDto> mapToCarModelDtos(List<CarModel> carModels) {
        return carModels.stream()
                .map(carModel -> mapToCarModelDto(carModel))
                .collect(Collectors.toList());
    }

    private static CarModelDto mapToCarModelDto(CarModel carModel) {
        return CarModelDto.builder()
                .idModel(carModel.getIdModel())
                .name(carModel.getName())
                .body(carModel.getBody())
                .build();
    }
}
