package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.TransferMoneyDto;
import com.timirov.bankingtransactionsapi.dto.TransferMoneyResponseDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.exception.InsufficientFundsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferMoneyService {

    private final static String TRANSLATION_COMPLETED = "Перевод выполнен";
    private final BankAccountService bankAccountService;

    @Transactional
    public TransferMoneyResponseDto transferMoneyId(TransferMoneyDto transferMoneyDto, String username) {
        BankAccount sender = bankAccountService.fetchUsername(username);

        if (sender.getMoney().compareTo(transferMoneyDto.getSum()) < 0) {
            throw new InsufficientFundsException();
        }

        BankAccount recipient = bankAccountService.fetchId(transferMoneyDto.getBankAccount());

        bankAccountService.subtractMoney(sender, transferMoneyDto.getSum());
        bankAccountService.addMoney(recipient, transferMoneyDto.getSum());

        return new TransferMoneyResponseDto(TRANSLATION_COMPLETED);
    }
}
