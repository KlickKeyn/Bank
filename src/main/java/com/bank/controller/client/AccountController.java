package com.bank.controller.client;

import com.bank.dao.model.Account;
import com.bank.dto.client_account.BaseClientAccountData;
import com.bank.dto.client_account.ClientAccountConnectData;
import com.bank.dto.client_account.ClientAccountMoneyData;
import com.bank.dto.client_account.ClientAccountOpenData;
import com.bank.service.bank_account_service.bank_account_business_logic.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/getAll")
    public List<Account> getAllClientAccounts(@RequestBody BaseClientAccountData baseClientAccountData) {
        return bankAccountService.getAllClientAccounts(baseClientAccountData);
    }

    @PostMapping("/createAccount")
    public Account openAccount(@RequestBody ClientAccountOpenData clientAccountOpenData) {
        return bankAccountService.openAccount(clientAccountOpenData);
    }

    @DeleteMapping("/deleteAccount")
    public void closeAccount(@RequestBody ClientAccountConnectData clientAccountConnectData) {
        bankAccountService.closeAccount(clientAccountConnectData);
    }

    @PatchMapping("/depositMoney")
    public Account depositMoney(@RequestBody ClientAccountMoneyData clientAccountMoneyData) {
        return bankAccountService.topUpAccount(clientAccountMoneyData);
    }

    @PatchMapping("/withdrawMoney")
    public Account withdrawMoney(@RequestBody ClientAccountMoneyData clientAccountMoneyData) {
        return bankAccountService.withdrawMoney(clientAccountMoneyData);
    }
}
