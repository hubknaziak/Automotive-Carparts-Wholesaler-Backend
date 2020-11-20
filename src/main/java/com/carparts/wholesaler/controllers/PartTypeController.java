package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.PartTypeDto;
import com.carparts.wholesaler.mappers.PartTypeMapper;
import com.carparts.wholesaler.services.PartTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PartTypeController {

    private final PartTypeService partTypeService;

    @CrossOrigin
    @GetMapping("/getPartTypes")
    public List<PartTypeDto> getPartTypes(){return PartTypeMapper.mapToPartTypeDtos(partTypeService.getPartTypes()); }
}
