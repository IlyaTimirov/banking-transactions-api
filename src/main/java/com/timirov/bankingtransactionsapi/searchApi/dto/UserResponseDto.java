package com.timirov.bankingtransactionsapi.searchApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private List<String> emails;
    private List<String> phones;
    private String fullName;
    private LocalDate dateOfBirth;
}
