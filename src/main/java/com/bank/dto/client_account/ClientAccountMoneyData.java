package com.bank.dto.client_account;

import lombok.Data;

@Data
public class ClientAccountMoneyData extends ClientAccountConnectData {
    private Long moneySum;
}
