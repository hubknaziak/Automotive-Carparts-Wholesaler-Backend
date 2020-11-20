package com.carparts.wholesaler.services;

import com.carparts.wholesaler.dtos.ClientDto;
import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.models.Employee;
import com.carparts.wholesaler.models.PersonalData;
import com.carparts.wholesaler.repositories.AccountRepository;
import com.carparts.wholesaler.repositories.ClientRepository;
import com.carparts.wholesaler.repositories.EmployeeRepository;
import com.carparts.wholesaler.repositories.PersonalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final PersonalDataRepository personalDataRepository;
    private final EmployeeRepository employeeRepository;

    public Client addClient(ClientDto clientDto){

        Account account = accountRepository.findByMaxId(); //SZUKAC PO EMAILU!!!
        PersonalData personalData = personalDataRepository.findByMaxId();

        Client client = new Client();
        client.setAccount(account);
        client.setCompanyName(clientDto.getCompanyName());
        client.setNip(clientDto.getNip());

        if(clientDto.getNip() != 0) {client.setType("company");}
        else{client.setType("individual");}

        client.setPersonalData(personalData);

        return clientRepository.save(client);
    }


    public String getClientType(int idClient){
        Optional<Client> client = clientRepository.findById(idClient);

        return client.get().getType();
    }

    public Client getClientByEmail(String email){
        Account account = accountRepository.findByEmail(email);
        if(account == null) return null;
        Optional<Employee> employee = employeeRepository.findById(account.getIdAccount());
        if(employee.isPresent()) return null;
        Optional<Client> client = clientRepository.findById(account.getIdAccount());
        return client.orElse(null);
    }
}
