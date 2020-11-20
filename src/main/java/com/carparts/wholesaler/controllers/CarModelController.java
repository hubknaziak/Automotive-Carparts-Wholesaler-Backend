package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.CarModelDto;
import com.carparts.wholesaler.mappers.CarModelMapper;
import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.models.CarModel;
import com.carparts.wholesaler.services.CarMakeService;
import com.carparts.wholesaler.services.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarModelController {

    private final CarModelService carModelService;

    @CrossOrigin
    @GetMapping("/getAllCarModels/{make_id}")
    public List<CarModelDto> getCarModels(@PathVariable int make_id){
        return CarModelMapper.mapToCarModelDtos(carModelService.getCarModels(make_id));
    }
}
