package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.PhoneRequestDto;
import com.timirov.bankingtransactionsapi.repository.BankAccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferMoneyService {

    private final BankAccountRepository bankAccountRepository;

    @Transactional
    public void transferMoneyPhone(PhoneRequestDto phoneRequestDto){
        // Сумма запрашиваемого перевода достаточно на счет если нет ошибка у вас недостаточно средств
        // первое находим есть ли такой номер у пользователя если
        // нету ошибка пользователя с таким номером не сущетсвует

        // Если все прошло
        // Получаем деньги пользователя отнимаем сумму перевода остток вставляем
        // Достаем пользователя по номеру телефона получаем его деньги плюсуем и вставляем в сущетсвующие
        // Делаем обновление двух пользователей
    }
}
