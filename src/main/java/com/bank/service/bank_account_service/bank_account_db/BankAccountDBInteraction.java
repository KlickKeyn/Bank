package com.bank.service.bank_account_service.bank_account_db;

import com.bank.dao.model.Account;

import java.util.List;

public interface BankAccountDBInteraction {
    List<Account> getAllClientAccount(Long clientId);

    List<Account> getAll();

    Account findById(Long id);

    Account save(Long clientId, Account account);

    Account update(Long clientId, Account account);

    void delete(Long id);
}
