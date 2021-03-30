package com.bank.dao.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shares")
@Data
@NoArgsConstructor
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "account")
//    private Account account;
}
