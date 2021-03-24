package com.bank.service.client_service.client_db;

import com.bank.exceptions.client.ClientException;
import com.bank.model.Client;
import com.bank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientDBService implements ClientDBInteraction {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        List<Client> clients = clientRepository.findAll();

        if (clients == null) {
            throw new ClientException("No clients in database");
        }

        return clients;
    }

    @Override
    public Client findById(Long id) {
        if (id == null) {
            throw new ClientException("Wrong id");
        }

        Optional<Client> clientOptional = clientRepository.findById(id);
        Client client = null;

        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }

        if (client == null) {
            throw new ClientException("No client with such id");
        }

        return client;
    }

    @Override
    public Client findByLogin(String login) {
        if (login == null) {
            throw new ClientException("No login");
        }

        if (login.isEmpty()) {
            throw new ClientException("Login is empty");
        }

        //TODO спросить у Стёпы, норма ли это или шлак ебаный
        Optional<Client> clientOptional = clientRepository.findClientByLogin(login);
        Client client = null;

        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }

        return client;
    }

    @Override
    public void save(Client client) {
        if (client == null) {
            throw new ClientException("No client");
        }

        clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        save(client);
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
