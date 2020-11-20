package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.CarMake;
import com.carparts.wholesaler.models.CarModel;
import com.carparts.wholesaler.repositories.CarMakeRepository;
import com.carparts.wholesaler.repositories.CarModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarModelService {

    private final CarModelRepository carModelRepository;

    public List<CarModel> getCarModels(int idMake){ return carModelRepository.findAllByMake_id(idMake);}
}
