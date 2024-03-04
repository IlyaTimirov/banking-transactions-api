package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.*;
import com.timirov.bankingtransactionsapi.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final BankAccountService bankAccountService;

    private final EmailService emailService;

    private final PhoneService phoneService;

    private final UserService userService;

    @Transactional
    public void createNewUser(CreateUserDto userRequestDto) {
        User user = userService.create(userRequestDto);
        bankAccountService.create(new BankAccountDto(userRequestDto.getDeposit(), user));
        emailService.create(new EmailDto(userRequestDto.getEmail()), user);
        phoneService.create(new PhoneDto(userRequestDto.getPhone()), user);
    }
}
