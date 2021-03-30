package com.bank.dao.model;

import com.bank.dao.model.enums.AccountStateEnum;
import com.bank.dao.model.enums.AccountTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
public class Account {
//TODO чё по конструкторам
    public Account() {
        money = 0L;
    }

    public Account(String accountType) {
        accountTypeEnum = AccountTypeEnum.valueOf(accountType);

        if (accountTypeEnum == AccountTypeEnum.CHECKING_ACCOUNT) {
            setAccountStateEnum(AccountStateEnum.WORKING);
        } else if (accountTypeEnum == AccountTypeEnum.SAVINGS_ACCOUNT) {
            setAccountStateEnum(AccountStateEnum.WAITING_DECISION);
        }
        money = 0L;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_type")
    private AccountTypeEnum accountTypeEnum;

    @Column(name = "state")
    private AccountStateEnum accountStateEnum;

    @Column(name = "money")
    private Long money;

//    @JoinColumn(name = "share")
//    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
//    private Share share;
}
