package com.bank.service.bank_account_service.bank_account_db;

import com.bank.model.Account;

import java.util.List;

public interface BankAccountDBInteraction {
    List<Account> getAllClientAccount(Long clientId);

    List<Account> getAll();

    Account findById(Long id);

    void save(Long clientId, Account account);

    void update(Long clientId, Account account);

    void delete(Long clientId, Long id);
}
