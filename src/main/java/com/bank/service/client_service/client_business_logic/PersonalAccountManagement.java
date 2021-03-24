package com.bank.service.client_service.client_business_logic;

import com.bank.dto.ClientData;
import com.bank.model.Client;

public interface PersonalAccountManagement {
    Client registration(ClientData clientData);

    void isTrueClient(ClientData clientData);

    void deleteClient(ClientData clientData);
}
