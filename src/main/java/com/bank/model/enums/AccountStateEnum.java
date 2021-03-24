package com.bank.model.enums;

public enum AccountStateEnum {
    LOCKED("LOCKED"),
    WORKING("WORKING"),
    WAITING_DECISION("WAITING_DECISION");

    private final String value;

    AccountStateEnum(String value) {
        this.value = value;
    }
}
