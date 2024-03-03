package com.timirov.bankingtransactionsapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequestDto {

    private Long id;

    @NotBlank(message = "Заполните почту!")
    @Email(message = "Неккоретная почта (ivanov@mail.ru)")
    private String email;
}
