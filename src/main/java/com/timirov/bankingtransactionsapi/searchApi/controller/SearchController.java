package com.timirov.bankingtransactionsapi.searchApi.controller;

import com.timirov.bankingtransactionsapi.searchApi.dto.UserResponseDto;
import com.timirov.bankingtransactionsapi.searchApi.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/search/")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/query")
    public ResponseEntity<List<UserResponseDto>> searchPhone(
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) LocalDate dateOfBirth,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String[] sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        List<UserResponseDto> users = searchService.searchUsers(dateOfBirth, phone, fullName, email, pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
