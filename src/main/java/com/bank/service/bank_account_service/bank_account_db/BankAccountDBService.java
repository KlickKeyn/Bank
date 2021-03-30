package com.bank.service.bank_account_service.bank_account_db;

import com.bank.exceptions.account.AccountException;
import com.bank.dao.model.Account;
import com.bank.dao.model.Client;
import com.bank.dao.repository.AccountRepository;
import com.bank.exceptions.client.ClientException;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if (id == null) {
            throw new AccountException("Wrong id");
        }

        return accountRepository.findById(id).orElseThrow(() -> new AccountException("No account with such id"));
    }

    @Override
    public Account save(Long clientId, Account account) {
        if (account == null) {
            throw new AccountException("Account is wrong");
        }

        Client client = clientDBService.findById(clientId);

        List<Account> accounts = client.getAccounts();
        accounts.add(account);

        clientDBService.save(client);

        return account;
    }

    @Override
    public Account update(Long clientId, Account account) {
        if (account == null) {
            throw new AccountException("Account is wrong");
        }

        Client client = clientDBService.findById(clientId);

        List<Account> accounts = client.getAccounts();
        accounts.add(account);

        clientDBService.save(client);

        return account;
    }

    @Override
    public void delete(Long id) {
        Account account = findById(id);

        accountRepository.delete(account);
    }
}
