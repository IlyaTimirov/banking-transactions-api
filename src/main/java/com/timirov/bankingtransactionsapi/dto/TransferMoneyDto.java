package com.timirov.bankingtransactionsapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferMoneyDto {

    @NotNull(message = "Укажите сумму перевода!")
    @Min(message = "Минимальная сумма перевода 10", value = 10)
    private BigDecimal sum;

    @NotNull(message = "Укажите ид получателя!")
    private Long bankAccount;

}
