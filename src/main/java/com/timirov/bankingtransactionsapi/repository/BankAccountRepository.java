package com.timirov.bankingtransactionsapi.repository;

import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}