package com.bank.model;

import com.bank.model.enums.AccountStateEnum;
import com.bank.model.enums.AccountTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
public class Account {
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
