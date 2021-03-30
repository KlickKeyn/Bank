package com.bank.service.client_service.client_db;

import com.bank.dao.model.Client;

import java.util.List;

public interface ClientDBInteraction {
    List<Client> getAll();

    Client findById(Long id);

    Client findByLogin(String login);

    Client save(Client client);

    Client update(Client client);

    void delete(Client client);
}
