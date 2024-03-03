package com.timirov.bankingtransactionsapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "Заполните логин!")
    private String username;

    @NotBlank(message = "Заполните пароль!")
    private String password;
}
