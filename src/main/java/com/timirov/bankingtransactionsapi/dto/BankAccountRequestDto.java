package com.timirov.bankingtransactionsapi.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BankAccountRequestDto {
    private BigDecimal money;
    private Long id;
}
