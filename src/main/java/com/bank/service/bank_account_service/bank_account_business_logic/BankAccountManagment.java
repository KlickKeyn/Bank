package com.bank.service.bank_account_service.bank_account_business_logic;

import com.bank.dao.model.Account;
import com.bank.dto.client_account.BaseClientAccountData;
import com.bank.dto.client_account.ClientAccountConnectData;
import com.bank.dto.client_account.ClientAccountMoneyData;
import com.bank.dto.client_account.ClientAccountOpenData;

import java.util.List;

public interface BankAccountManagment {
    Account openAccount(ClientAccountOpenData clientAccountOpenData);

    void closeAccount(ClientAccountConnectData clientAccountConnectData);

    Account topUpAccount(ClientAccountMoneyData clientAccountMoneyData);

    Account withdrawMoney(ClientAccountMoneyData clientAccountMoneyData);

    List<Account> getAllClientAccounts(BaseClientAccountData baseClientAccountData);
}
