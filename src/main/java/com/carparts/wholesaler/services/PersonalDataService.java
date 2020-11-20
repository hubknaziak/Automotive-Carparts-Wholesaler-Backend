package com.carparts.wholesaler.services;

import com.carparts.wholesaler.dtos.PersonalDataDto;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.models.PersonalData;
import com.carparts.wholesaler.repositories.ClientRepository;
import com.carparts.wholesaler.repositories.PersonalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;
    private final ClientRepository clientRepository;

    public PersonalData addPersonalData(PersonalDataDto personalDataDto){
        PersonalData personalData = new PersonalData();

        personalData.setFirstName(personalDataDto.getFirstName());
        personalData.setLast_Name(personalDataDto.getLastName());
        personalData.setPhoneNumber(personalDataDto.getPhoneNumber());
        personalData.setStreet(personalDataDto.getStreet());
        personalData.setHouseNumber(personalDataDto.getHouseNumber());
        personalData.setApartmentNumber(personalDataDto.getApartmentNumber());
        personalData.setPostCode(personalDataDto.getPostcode());
        personalData.setCity(personalDataDto.getCity());
        personalData.setCountry(personalDataDto.getCountry());

        return personalDataRepository.save(personalData);
    }

    public PersonalData updatePersonalData(PersonalDataDto personalDataDto, int idClient){
        Optional<Client> client = clientRepository.findById(idClient);

        PersonalData personalDataDB = client.get().getPersonalData();
        if(!personalDataDto.getFirstName().equals("null")) personalDataDB.setFirstName(personalDataDto.getFirstName());
        if(!personalDataDto.getLastName().equals("null")) personalDataDB.setLast_Name(personalDataDto.getLastName());
        if(!personalDataDto.getPhoneNumber().equals("null")) personalDataDB.setPhoneNumber(personalDataDto.getPhoneNumber());
        if(!personalDataDto.getStreet().equals("null")) personalDataDB.setStreet(personalDataDto.getStreet());
        if(personalDataDto.getHouseNumber() != 0) personalDataDB.setHouseNumber(personalDataDto.getHouseNumber());
        if(personalDataDto.getApartmentNumber() != 0) personalDataDB.setApartmentNumber(personalDataDto.getApartmentNumber());
        if(!personalDataDto.getCity().equals("null")) personalDataDB.setCity(personalDataDto.getCity());
        if(!personalDataDto.getPostcode().equals("null")) personalDataDB.setPostCode(personalDataDto.getPostcode());
        if(!personalDataDto.getCountry().equals("null")) personalDataDB.setCountry(personalDataDto.getCountry());

        return personalDataRepository.save(personalDataDB);
    }

    public PersonalData getPersonalData(int idClient){
        Optional<Client> client = clientRepository.findById(idClient);

        PersonalData personalData = client.get().getPersonalData();

        return  personalData;
    }
}
