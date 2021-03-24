package com.bank.service.bank_account_service.bank_account_business_logic;

import com.bank.dto.ClientData;
import com.bank.model.Account;
import com.bank.service.bank_account_service.bank_account_db.BankAccountDBService;
import com.bank.service.client_service.client_business_logic.ClientPersonalAccountManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService implements BankAccountManagment{

    private final ClientPersonalAccountManagement clientPersonalAccountManagement;
    private final BankAccountDBService bankAccountDBService;

    @Override
    public void openAccount(String typeEnum) {

    }

    @Override
    public void closeAccount(Long id) {

    }

    @Override
    public void topUpAccount(Long id, Long moneySum) {

    }

    @Override
    public void withdrawMoney(Long id, Long moneySum) {

    }

    @Override
    public List<Account> getAllClientAccounts(ClientData clientData) {
        clientPersonalAccountManagement.isTrueClient(clientData);

        Long clientId = clientData.getId();
        List<Account> clientAccount = bankAccountDBService.getAllClientAccount(clientId);

        return clientAccount;
    }
}
