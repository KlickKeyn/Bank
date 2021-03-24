package com.bank.service.bank_account_service.bank_account_business_logic;

import com.bank.dto.ClientData;
import com.bank.model.Account;

import java.util.List;

public interface BankAccountManagment {
    void openAccount(String typeEnum);

    void closeAccount(Long id);

    void topUpAccount(Long id, Long moneySum);

    void withdrawMoney(Long id, Long moneySum);

    List<Account> getAllClientAccounts(ClientData clientData);
}
