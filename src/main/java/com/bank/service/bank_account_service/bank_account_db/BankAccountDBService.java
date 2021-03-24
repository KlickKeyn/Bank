package com.bank.service.bank_account_service.bank_account_db;

import com.bank.exceptions.account.AccountException;
import com.bank.model.Account;
import com.bank.model.Client;
import com.bank.repository.AccountRepository;
import com.bank.repository.ClientRepository;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO переделать всё на использование сервисов клиента

@Service
@RequiredArgsConstructor
public class BankAccountDBService implements BankAccountDBInteraction {

    private final AccountRepository accountRepository;
    private final ClientDBService clientDBService;

    @Override
    public List<Account> getAllClientAccount(Long clientId) {
        Client client = clientDBService.findById(clientId);

        List<Account> clientAccounts = client.getAccounts();

        if (clientAccounts.isEmpty()) {
            throw new AccountException("The client has no accounts");
        }

        return clientAccounts;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            throw new AccountException("No accounts");
        }

        return accounts;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public void save(Long clientId, Account account) {

    }

    @Override
    public void update(Long clientId, Account account) {

    }

    @Override
    public void delete(Long clientId, Long id) {

    }
}
