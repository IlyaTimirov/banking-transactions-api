package com.timirov.bankingtransactionsapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotBlank(message = "Заполните логин!")
    private String username;

    @NotBlank(message = "Заполните пароль!")
    private String password;


    @NotBlank(message = "Заполните почту!")
    @Email(message = "Неккоретная почта (ivanov@mail.ru)")
    private String email;

    @NotBlank(message = "Заполните номер!")
    @Pattern(regexp = "\\d{10}", message = "Номер телефона должен состоять из 10 фицр!")
    private String phone;

    @NotNull(message = "Заполните дату рождения!")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Введите Фамилию Имя Отчетсво (Иванов Иван Иванович)")
    private String fullName;

    @NotNull(message = "Нужно указать начальный депозит")
    private BigDecimal deposit;
}
