package com.carparts.wholesaler.services;

import com.carparts.wholesaler.dtos.PartDto;
import com.carparts.wholesaler.models.*;
import com.carparts.wholesaler.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;
    private final PartTypeRepository partTypeRepository;
    private final EngineRepository engineRepository;
    private final CarModelRepository carModelRepository;
    private final GenerationRepository generationRepository;

    public List<Part> getPartsByParams(int idModel, int idEngine, int idPartType) {return partRepository.findPartsByParams(idModel, idEngine, idPartType); }

    public Part addNewPart(PartDto partDto){
        Part part = new Part();
        PartType partType = partTypeRepository.findByName(partDto.getPartTypeName());

        part.setPartType(partType);
        part.setName(partDto.getName());

        //partRepository.save(part);

        String[] engineCodes = partDto.getEngineCodes().split(",");
        String[] modelNames = partDto.getModelNames().split(",");
        String[] generationNames = partDto.getGenerationNames().split(",");

        List<Engine> engines = new ArrayList<>();
        List<CarModel> carModels = new ArrayList<>();
        List<Generation> generations = new ArrayList<>();
        List<CarModel> machModels = new ArrayList<>();

        for (String e : engineCodes) {
            Engine engine = engineRepository.findByCode(e);
            engines.add(engine); //wyszukujemy pasujace silniki
        }
        for(String g : generationNames){
            Generation generation = generationRepository.findByName(g);
            generations.add(generation); //wyszukujemy pasujace generacje
        }
        for (String e : modelNames) {
            carModels = carModelRepository.findByName(e); //wyszukujemy pasujace modelu
        }
        for (Generation g : generations){
            for (CarModel cm : carModels){ //sprawdzamy czy generacja pasuje do modelu
                if(g.getCarModel().getIdModel() == cm.getIdModel()){
                    machModels.add(cm); //jesli tak, to dajemy do wyszukanych
                }
            }
        }

        //part.getEngines().addAll(engines);
        //part.getCarModels().addAll(machModels);
        part.setEngines(engines);
        part.setCarModels(machModels); //ustawiamy pasujace parametry

        return partRepository.save(part);

    }
}
