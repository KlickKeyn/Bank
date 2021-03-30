package com.bank.dao.repository;

import com.bank.dao.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long id);
}
