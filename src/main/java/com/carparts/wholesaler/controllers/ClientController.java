package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.dtos.ClientDto;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.services.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @CrossOrigin
    @PostMapping("addClient")
    public Client addClient(@RequestBody ClientDto clientDto){
        return clientService.addClient(clientDto);
    }

//    @CrossOrigin
//    @PutMapping("updateClient/{idClient}")
//    public Client updateClient(@RequestBody ClientDto clientDto, @PathVariable int idClient){ return clientService.updateClient(clientDto, idClient);}

    @CrossOrigin
    @GetMapping("getClientType/{idClient}")
    public String getClientType(@PathVariable int idClient){ return clientService.getClientType(idClient);}

    @CrossOrigin
    @GetMapping("getClientByEmail")
    public Client getClientByEmail(@RequestParam String email){
        return clientService.getClientByEmail(email);
    }

}
