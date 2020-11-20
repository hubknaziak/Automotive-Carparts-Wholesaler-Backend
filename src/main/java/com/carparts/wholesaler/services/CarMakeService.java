package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.repositories.CarMakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarMakeService {

    private final CarMakeRepository carMakeRepository;

    public List<CarMake> getCarMakes(){ return carMakeRepository.findAll(Sort.by(Sort.Direction.ASC, "name")); }
}
