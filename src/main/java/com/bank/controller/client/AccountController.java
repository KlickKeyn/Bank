package com.bank.controller.client;

import com.bank.dto.ClientData;
import com.bank.model.Account;
import com.bank.service.bank_account_service.bank_account_business_logic.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/getAll")
    public List<Account> getAllClientAccounts(@RequestBody ClientData clientData) {
        return bankAccountService.getAllClientAccounts(clientData);
    }
}
