package com.bank.dao.model;

import com.bank.dao.model.enums.LoanTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "loan_amount")
    private Long loanAmount;

    @Column(name = "months_before_payment")
    private int monthsBe4Payment;

    @Column(name = "loan_type")
    private LoanTypeEnum loanTypeEnum;
}
