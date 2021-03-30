package com.bank.service.client_service.client_db;

import com.bank.exceptions.client.ClientException;
import com.bank.dao.model.Client;
import com.bank.dao.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientDBService implements ClientDBInteraction {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            throw new ClientException("No clients in database");
        }

        return clients;
    }

    @Override
    public Client findById(Long id) {
        if (id == null) {
            throw new ClientException("Wrong id");
        }

        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientException("No client with such id"));
    }

    @Override
    public Client findByLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new ClientException("Login is null or empty");
        }
        //TODO
        return clientRepository.findClientByLogin(login)
                .orElseThrow(() -> new ClientException("No client with such login"));
    }

    @Override
    public Client save(Client client) {
        if (client == null) {
            throw new ClientException("No client");
        }

        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        if (client == null) {
            throw new ClientException("No client");
        }

        return clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        if (client == null) {
            throw new ClientException("No client");
        }

        Client clientFromDb = findById(client.getId());

        if (clientFromDb == null) {
            throw new ClientException("There is no such client in database");
        }

        clientRepository.delete(clientFromDb);
    }
}
