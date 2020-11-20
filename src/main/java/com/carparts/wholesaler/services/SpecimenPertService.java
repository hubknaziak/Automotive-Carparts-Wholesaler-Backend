package com.carparts.wholesaler.services;

import com.carparts.wholesaler.dtos.PartDto;
import com.carparts.wholesaler.models.Part;
import com.carparts.wholesaler.models.SpecimenPart;
import com.carparts.wholesaler.repositories.PartRepository;
import com.carparts.wholesaler.repositories.SpecimenPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecimenPertService {

    private final SpecimenPartRepository specimenPartRepository;
    private final PartRepository partRepository;

    public List<SpecimenPart> getSpecimenPart(String code){
        List<SpecimenPart> specimenPart = new ArrayList<>();
        specimenPart = specimenPartRepository.findByOe(code);
        if(specimenPart != null){
            return specimenPart;
        }
        return specimenPartRepository.findByProducerCode(code);
    }

    public SpecimenPart addSpecimenPart(PartDto partDto, int idPart){
        SpecimenPart specimenPart = new SpecimenPart();
        Optional<Part> part = partRepository.findById(idPart);

        specimenPart.setPart(part.get());
        specimenPart.setName(partDto.getName());
        specimenPart.setOe(partDto.getOe());
        specimenPart.setProducer(partDto.getProducer());
        specimenPart.setProducerCode(partDto.getProducerCode());
        specimenPart.setNetPrice(partDto.getNetPrice());
        specimenPart.setGrossPrice(partDto.getNetPrice() + (partDto.getNetPrice() * 0.23));
        specimenPart.setQuantity(partDto.getQuantity());
        specimenPart.setInformations(partDto.getInformation());

        return specimenPartRepository.save(specimenPart);
    }

    public SpecimenPart updateSpecimenPart(PartDto partDto, int idSpecimenPart){
        Optional<SpecimenPart> specimenPart = specimenPartRepository.findById(idSpecimenPart);
        List<SpecimenPart> specimenPartOe = specimenPartRepository.findByOe(partDto.getOe());
        List<SpecimenPart> specimenPartProducerCode = specimenPartRepository.findByProducerCode(partDto.getProducerCode());

        specimenPart.get().setName(partDto.getName());
        if(specimenPartOe == null) specimenPart.get().setOe(partDto.getOe());
        if(specimenPartProducerCode == null) specimenPart.get().setProducerCode(partDto.getProducerCode());
        specimenPart.get().setProducer(partDto.getProducer());
        specimenPart.get().setNetPrice(partDto.getNetPrice());
        specimenPart.get().setGrossPrice(partDto.getGrossPrice());
        specimenPart.get().setQuantity(partDto.getQuantity());
        specimenPart.get().setInformations(partDto.getInformation());

        return specimenPartRepository.save(specimenPart.get());
    }

    public SpecimenPart decreaseQuantity(int idSpecimenPart, int quantity){
        Optional<SpecimenPart> specimenPart = specimenPartRepository.findById(idSpecimenPart);

        specimenPart.get().setQuantity(specimenPart.get().getQuantity() - quantity);

        return specimenPartRepository.save(specimenPart.get());
    }

    public void deleteSpecimenPart(int idSpecimenPart){
        specimenPartRepository.deleteSpecimenPart(idSpecimenPart);
    }
}
