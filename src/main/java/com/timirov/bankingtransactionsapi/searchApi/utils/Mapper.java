package com.timirov.bankingtransactionsapi.searchApi.utils;

import com.timirov.bankingtransactionsapi.entity.Email;
import com.timirov.bankingtransactionsapi.entity.Phone;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.searchApi.dto.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {
    public List<UserResponseDto> toDtos(List<User> users){
        return users.stream().map(user -> UserResponseDto.builder()
                .emails(user.getEmails().stream().map(Email::getEmail).toList())
                .phones(user.getPhones().stream().map(Phone::getPhone).toList())
                .fullName(user.getFullName())
                .dateOfBirth(user.getDateOfBirth())
                .build()).toList();
    }
}
