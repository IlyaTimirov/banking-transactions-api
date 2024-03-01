package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.CreateUserDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.entity.Email;
import com.timirov.bankingtransactionsapi.entity.Phone;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User create(CreateUserDto userRequestDto) {
        return userRepository.save(User.builder()
                .username(userRequestDto.getUsername())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .dateOfBirth(userRequestDto.getDateOfBirth())
                .fullName(userRequestDto.getFullName())
                .build());
    }

    public void update(User user){
        userRepository.save(user);
    }
}
