package com.timirov.bankingtransactionsapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequestDto {
    private Long id;
    private String email;
}
