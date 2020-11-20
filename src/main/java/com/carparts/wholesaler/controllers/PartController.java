package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.PartDto;
import com.carparts.wholesaler.models.Part;
import com.carparts.wholesaler.services.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @CrossOrigin
    @GetMapping("/getPartsByParams/{idModel}/{idEngine}/{idPartType}")
    public List<Part> getPartsByParams(@PathVariable int idModel, @PathVariable int idEngine, @PathVariable int idPartType){
        return partService.getPartsByParams(idModel, idEngine, idPartType);
    }

    @CrossOrigin
    @PostMapping("addNewPart")
    public Part addNewPart(@RequestBody PartDto partDto){
        return partService.addNewPart(partDto);
    }

}
