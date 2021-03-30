package com.bank.service.client_service.client_business_logic;

import com.bank.dto.client.ClientData;
import com.bank.exceptions.client.ClientException;
import com.bank.dao.model.Client;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientPersonalAccountManagement implements PersonalAccountManagement {

    private final ClientDBService clientDBService;

    @Override
    public Client registration(ClientData clientData) {
        //todo where NPE situation DONE
        if (clientData == null) {
            throw new ClientException("Client DTO is null");
        }

        String login = clientData.getLogin();
        String password = clientData.getPassword();

        try {
            Client clientFromDb = clientDBService.findByLogin(login);
        } catch (ClientException ex) {
            Client client = new Client(login, password);

            log.info("Client is registered");
            return clientDBService.save(client);
        }

        throw new ClientException("There is client with such login");
    }

    @Override
    public void deleteClient(ClientData clientData) {
        if (isClientValid(clientData)) {
            Client client = clientDBService.findByLogin(clientData.getLogin());

            clientDBService.delete(client);
            log.info("Client deleted");
        }
    }

    private boolean isClientValid(ClientData clientData) {
        if (clientData == null) {
            throw new ClientException("Client DTO is null");
        }

        String login = clientData.getLogin();
        String password = clientData.getPassword();

        if (password == null || password.isEmpty()) {
            throw new ClientException("Password is null or empty");
        }

        Client client = clientDBService.findByLogin(login);

        if (client == null) {
            throw new ClientException("There is no such client");
        }

        if (!client.getPassword().equals(password)) {
            throw new ClientException("Wrong password");
        }

        return true;
    }
}