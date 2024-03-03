package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.entity.BankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final BankAccountService bankAccountService;
    private final static Double MAX_PERCENT = 2.07;

    private final static Double DEPOSIT_INCREASE_PERCENTAGE = 0.05;

    @Scheduled(cron = "0 * * * * *")
    public void addMoneyUser() {
        List<BankAccount> bankAccounts = bankAccountService.getAll();

        bankAccounts.forEach(bankAccount -> {
            if (bankAccount.getInitialDeposit().multiply(BigDecimal.valueOf(MAX_PERCENT)).compareTo(bankAccount.getMoney()) < 0) {
                BigDecimal percent = bankAccount.getMoney().multiply(BigDecimal.valueOf(DEPOSIT_INCREASE_PERCENTAGE));
                bankAccount.setMoney(bankAccount.getMoney().add(percent));
                bankAccountService.update(bankAccount);
            }
        });
    }
}
