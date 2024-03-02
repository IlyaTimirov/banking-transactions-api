package com.timirov.bankingtransactionsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferMoneyDto {
    private BigDecimal sum;
    private Long bankAccount;
}
