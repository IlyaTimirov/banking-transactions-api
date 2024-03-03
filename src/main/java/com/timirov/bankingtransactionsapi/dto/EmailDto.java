package com.timirov.bankingtransactionsapi.dto;

import com.timirov.bankingtransactionsapi.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String email;
}
