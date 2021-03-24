package com.bank.service.client_service.client_business_logic;

import com.bank.dto.ClientData;
import com.bank.exceptions.client.ClientException;
import com.bank.model.Client;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientPersonalAccountManagement implements PersonalAccountManagement {

    private final ClientDBService clientDBService;

    @Override
    public Client registration(ClientData clientData) {
        String login = clientData.getLogin();
        String password = clientData.getPassword();

        Client clientFromDb = clientDBService.findByLogin(login);

        if (clientFromDb != null) {
            throw new ClientException("There is client with such login");
        }

        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);

        clientDBService.save(client);

        return client;
    }

    @Override
    public void isTrueClient(ClientData clientData) {
        String login = clientData.getLogin();
        String password = clientData.getPassword();

        Client client = clientDBService.findByLogin(login);

        if (client == null) {
            throw new ClientException("There is no such client");
        }

        if (!client.getPassword().equals(password)) {
            throw new ClientException("Wrong password");
        }


    }

    @Override
    public void deleteClient(ClientData clientData) {
        isTrueClient(clientData);

        String clientLogin = clientData.getLogin();
        Client client = clientDBService.findByLogin(clientLogin);

        clientDBService.delete(client);
    }
}