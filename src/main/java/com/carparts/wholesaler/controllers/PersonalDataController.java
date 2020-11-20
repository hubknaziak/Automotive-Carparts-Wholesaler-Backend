package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.PersonalDataDto;
import com.carparts.wholesaler.models.PersonalData;
import com.carparts.wholesaler.services.PersonalDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @CrossOrigin
    @PostMapping("addPersonalData")
    public PersonalData addPersonalData(@RequestBody PersonalDataDto personalDataDto){
        return personalDataService.addPersonalData(personalDataDto);
    }

    @CrossOrigin
    @PutMapping("updatePersonalData/{idClient}")
    public PersonalData updatePersonalDate(@RequestBody PersonalDataDto personalDataDto, @PathVariable int idClient){
        return personalDataService.updatePersonalData(personalDataDto, idClient);
    }

    @CrossOrigin
    @GetMapping("getPersonalData/{idClient}")
    public PersonalData getPersonalData(@PathVariable int idClient){
        return personalDataService.getPersonalData(idClient);
    }
}
