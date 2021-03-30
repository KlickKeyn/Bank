package com.bank.service.client_service.client_business_logic;

import com.bank.dto.client.ClientData;
import com.bank.dao.model.Client;

public interface PersonalAccountManagement {
    Client registration(ClientData clientData);

    void deleteClient(ClientData clientData);
}
