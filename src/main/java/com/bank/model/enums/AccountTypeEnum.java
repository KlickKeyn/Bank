package com.bank.model.enums;

public enum AccountTypeEnum {
    CHECKING_ACCOUNT("CHECKING_ACCOUNT"),
    SAVINGS_ACCOUNT("SAVINGS_ACCOUNT");

    private final String value;

    AccountTypeEnum(String value) {
        this.value = value;
    }
}
