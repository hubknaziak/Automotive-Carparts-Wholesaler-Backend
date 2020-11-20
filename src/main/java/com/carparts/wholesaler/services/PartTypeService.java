package com.carparts.wholesaler.services;

import com.carparts.wholesaler.models.PartType;
import com.carparts.wholesaler.repositories.PartTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartTypeService {

    private final PartTypeRepository partTypeRepository;

    public List<PartType> getPartTypes(){return partTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));}

}
