package com.timirov.bankingtransactionsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String fullName;
    private BigDecimal check;
}
