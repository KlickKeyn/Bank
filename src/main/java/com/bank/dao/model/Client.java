package com.bank.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "login")
    private String login;
    @NonNull
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "account")
    @JoinColumn(name = "account_id")
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "loans")
    @JoinColumn(name = "loan_id")
    private List<Loan> loans;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "shares")
    @JoinColumn(name = "share_id")
    private List<Share> shares;

    @OneToMany
    @Column(name = "history")
    @JoinColumn(name = "event_id")
    private List<Event> history;
}
