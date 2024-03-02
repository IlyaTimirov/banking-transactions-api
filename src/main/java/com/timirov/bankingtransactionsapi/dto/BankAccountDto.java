package com.timirov.bankingtransactionsapi.dto;

import com.timirov.bankingtransactionsapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {
    private BigDecimal money;
    private User user;
}
