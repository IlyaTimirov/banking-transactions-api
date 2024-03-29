package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.BankAccountDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccount create(BankAccountDto bankAccountDto) {
        return bankAccountRepository.save(BankAccount.builder()
                .money(bankAccountDto.getMoney())
                .initialDeposit(bankAccountDto.getMoney())
                .user(bankAccountDto.getUser())
                .build());
    }

    public BankAccount fetchUsername(String username) {
        return bankAccountRepository.findBankAccountByUserUsername(username).orElseThrow();
    }

    public void addMoney(BankAccount bankAccount, BigDecimal sum){
        bankAccount.setMoney(bankAccount.getMoney().add(sum));
        bankAccountRepository.save(bankAccount);
    }

    public void subtractMoney(BankAccount bankAccount, BigDecimal sum){
        bankAccount.setMoney(bankAccount.getMoney().subtract(sum));
        bankAccountRepository.save(bankAccount);
    }

    public BankAccount fetchId(Long id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }

    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }
}
