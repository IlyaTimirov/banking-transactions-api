package com.timirov.bankingtransactionsapi.dto;

import com.timirov.bankingtransactionsapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String email;
    private User user;
}
