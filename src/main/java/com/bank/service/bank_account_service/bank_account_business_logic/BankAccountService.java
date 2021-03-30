package com.bank.service.bank_account_service.bank_account_business_logic;

import com.bank.dao.model.Account;
import com.bank.dao.model.Client;
import com.bank.dto.client_account.BaseClientAccountData;
import com.bank.dto.client_account.ClientAccountConnectData;
import com.bank.dto.client_account.ClientAccountMoneyData;
import com.bank.dto.client_account.ClientAccountOpenData;
import com.bank.exceptions.account.AccountException;
import com.bank.service.bank_account_service.bank_account_db.BankAccountDBService;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService implements BankAccountManagment{

    private final BankAccountDBService bankAccountDBService;
    private final ClientDBService clientDBService;


    @Override
    public Account openAccount(ClientAccountOpenData clientAccountOpenData) {
        if (clientAccountOpenData == null) {
            throw new AccountException("Wrong client account data");
        }

        if (clientAccountOpenData.getTypeEnum() == null) {
            throw new AccountException("Wrong account type");
        }

        Client client = clientDBService.findById(clientAccountOpenData.getClientId());

        List<Account> accounts = client.getAccounts();

        String accountType = clientAccountOpenData.getTypeEnum();
        Account account = new Account(accountType); //TODO норм ли такой конструктор?

        accounts.add(account);
        client.setAccounts(accounts);

        clientDBService.save(client);

        return account;
    }

    @Override
    public void closeAccount(ClientAccountConnectData clientAccountConnectData) {
        if (clientAccountConnectData == null) { //TODO много копипаста, шо делац
            throw new AccountException("Client account data is wrong");
        }

        Long clientId = clientAccountConnectData.getClientId();
        Long accountId = clientAccountConnectData.getAccountId();

        Client client = clientDBService.findById(clientId);
        Account account = bankAccountDBService.findById(accountId);

        List<Account> accounts = client.getAccounts();

        Account accountForDelete = accounts.stream().filter(acc -> acc.equals(account)).
                findFirst().orElseThrow(() -> new AccountException("This client have not such account"));

        if (accountForDelete.getMoney() != 0) {
            throw new AccountException("There is money left in this account");
        }

        accounts.remove(accountForDelete);

        client.setAccounts(accounts);

        clientDBService.save(client);
    }

    @Override
    public Account topUpAccount(ClientAccountMoneyData clientAccountMoneyData) {
        if (clientAccountMoneyData == null) {
            throw new AccountException("Client account data is wrong");
        }

        Long depositAmount = clientAccountMoneyData.getMoneySum();

        if (depositAmount == null || depositAmount < 0) {
            throw new AccountException("Wrong money sum");
        }

        Long clientId = clientAccountMoneyData.getClientId();
        Long accountId = clientAccountMoneyData.getAccountId();

        Client client = clientDBService.findById(clientId);
        Account account = bankAccountDBService.findById(accountId);

        List<Account> accounts = client.getAccounts();

        Account clientAccount = accounts.stream().filter(acc -> acc.equals(account)).
                findFirst().orElseThrow(() -> new AccountException("This client have not such account"));

        clientAccount.setMoney(clientAccount.getMoney() + depositAmount);
        clientAccount = bankAccountDBService.save(clientId, account);

        return clientAccount;
    }

    @Override
    public Account withdrawMoney(ClientAccountMoneyData clientAccountMoneyData) {
        if (clientAccountMoneyData == null) {
            throw new AccountException("Client account data is wrong");
        }

        Long withdrawAmount = clientAccountMoneyData.getMoneySum();

        if (withdrawAmount == null || withdrawAmount < 0) {
            throw new AccountException("Wrong money sum");
        }
        Long clientId = clientAccountMoneyData.getClientId();
        Long accountId = clientAccountMoneyData.getAccountId();

        Client client = clientDBService.findById(clientId);
        Account account = bankAccountDBService.findById(accountId);

        List<Account> accounts = client.getAccounts();

        Account clientAccount = accounts.stream().filter(acc -> acc.equals(account)).
                findFirst().orElseThrow(() -> new AccountException("This client have not such account"));

        Long clientMoney = clientAccount.getMoney();
        if (clientMoney < withdrawAmount){
            throw new AccountException("Account have not that money");
        }

        clientAccount.setMoney(clientMoney - withdrawAmount);
        clientAccount = bankAccountDBService.save(clientId, account);

        return clientAccount;
    }

    @Override
    public List<Account> getAllClientAccounts(BaseClientAccountData baseClientAccountData) {
        return bankAccountDBService.getAllClientAccount(baseClientAccountData.getClientId());
    }
}
