package com.bank.service.client_service.client_db;

import com.bank.model.Client;

import java.util.List;

public interface ClientDBInteraction {
    List<Client> getAll();

    Client findById(Long id);

    Client findByLogin(String login);

    void save(Client client);

    void update(Client client);

    void delete(Client client);
}
