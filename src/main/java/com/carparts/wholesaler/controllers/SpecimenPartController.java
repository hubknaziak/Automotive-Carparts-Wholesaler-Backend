package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.PartDto;
import com.carparts.wholesaler.models.SpecimenPart;
import com.carparts.wholesaler.services.SpecimenPertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecimenPartController {

    private final SpecimenPertService specimenPartService;

    @CrossOrigin
    @GetMapping("getSpecimenPart/{code}")
    public List<SpecimenPart> getSpecimenPart(@PathVariable String code){

        return specimenPartService.getSpecimenPart(code);
    }

    @CrossOrigin
    @PostMapping("addSpecimenPart/{idPart}")
    public SpecimenPart addSpecimenPart(@RequestBody PartDto partDto, @PathVariable int idPart){
        return specimenPartService.addSpecimenPart(partDto, idPart);
    }

    @CrossOrigin
    @PutMapping("updateSpecimenPart/{idSpecimenPart}")
    public SpecimenPart updateSpecimenPart(@RequestBody PartDto partDto, @PathVariable int idSpecimenPart){
        return  specimenPartService.updateSpecimenPart(partDto, idSpecimenPart);
    }

    @CrossOrigin
    @PutMapping("decreaseQuantity/{idSpecimenPart}/{quantity}")
    public SpecimenPart decreaseQuantity(@PathVariable int idSpecimenPart, @PathVariable int quantity){
        return specimenPartService.decreaseQuantity(idSpecimenPart, quantity);
    }

    @CrossOrigin
    @DeleteMapping("deleteSpecimenPart/{idSpecimenPart}")
    public void deleteSpecimenPart(@PathVariable int idSpecimenPart){
        specimenPartService.deleteSpecimenPart(idSpecimenPart);
    }
}
