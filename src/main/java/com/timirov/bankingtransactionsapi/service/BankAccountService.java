package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.BankAccountDto;
import com.timirov.bankingtransactionsapi.dto.BankAccountRequestDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccount create(BankAccountDto bankAccountDto) {
        return bankAccountRepository.save(BankAccount.builder()
                .check(bankAccountDto.getCheck())
                .user(bankAccountDto.getUser())
                .build());
    }

    public BankAccount fetchUsername(String username){
        return bankAccountRepository.findBankAccountByUserUsername(username).orElseThrow();
    }

    public void update(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }
}
