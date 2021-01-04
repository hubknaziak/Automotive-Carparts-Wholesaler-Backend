package com.carparts.wholesaler.controllers;

import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.services.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

class ClientControllerTest {

    @Autowired
    private ClientService clientService;
    @Test
    void addClient() {
    }

    @Test
    void getClientType() {
    }

    @Test
    void getClientByEmail() throws Exception {
        ClientController controller = new ClientController(clientService);
        Client client = controller.getClientByEmail("nowy@nowy.pl0");
        assertNotNull(client);
    }
}