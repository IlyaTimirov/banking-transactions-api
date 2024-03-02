package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.TransferMoneyDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferMoneyService {

    private final BankAccountService bankAccountService;

    private final UserService userService;
    @Transactional
    public void transferMoneyPhone(TransferMoneyDto transferMoneyDto, String username){
        BankAccount sender = bankAccountService.fetchUsername(username);
        if(sender.getCheck().compareTo(transferMoneyDto.getSum()) > 0){
            // Ошибка денег недостаточно
        }
        BankAccount recipient = bankAccountService.fetchUsername(username);

        sender.setCheck(sender.getCheck().subtract(transferMoneyDto.getSum()));
        recipient.setCheck(recipient.getCheck().add(transferMoneyDto.getSum()));

        bankAccountService.update(sender);
        bankAccountService.update(recipient);
    }
}
