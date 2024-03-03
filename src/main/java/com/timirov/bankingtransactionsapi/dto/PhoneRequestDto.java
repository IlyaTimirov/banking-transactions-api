package com.timirov.bankingtransactionsapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneRequestDto {

    private Long id;

    @NotBlank(message = "Заполните номер!")
    @Pattern(regexp = "\\d{10}", message = "Номер телефона должен состоять из 10 фицр!")
    private String phone;
}
