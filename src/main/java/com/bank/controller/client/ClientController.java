package com.bank.controller.client;

import com.bank.dto.ClientData;
import com.bank.model.Client;
import com.bank.service.client_service.client_business_logic.ClientPersonalAccountManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientPersonalAccountManagement clientPersonalAccountManagement;

    @PostMapping("/registration")
    public Client registerClient(@RequestBody ClientData clientData) {
        return clientPersonalAccountManagement.registration(clientData);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody ClientData clientData) {
        clientPersonalAccountManagement.deleteClient(clientData);
    }
}
