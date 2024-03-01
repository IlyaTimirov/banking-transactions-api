package com.timirov.bankingtransactionsapi.dto;

import com.timirov.bankingtransactionsapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {
    private String phone;
    private User user;
}
