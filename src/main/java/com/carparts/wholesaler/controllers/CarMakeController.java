package com.carparts.wholesaler.controllers;


import com.carparts.wholesaler.dtos.CarMakeDto;
import com.carparts.wholesaler.mappers.CarMakeMapper;
import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.services.CarMakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CarMakeController {

    private final CarMakeService carMakeService;

    @CrossOrigin
    @GetMapping("/getAllCarMakes")
    public List<CarMakeDto> getCarMakes(){
        return CarMakeMapper.mapToCarMakeDtos(carMakeService.getCarMakes());
    }


}
