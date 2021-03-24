package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        AccountTypeEnum typeEnum = AccountTypeEnum.CHECKING_ACCOUNT;
//
//        AccountTypeEnum typeEnumFromString = AccountTypeEnum.valueOf("CHECKING_ACCOUNT");
    }
}
