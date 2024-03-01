package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.EmailRequestDto;
import com.timirov.bankingtransactionsapi.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/email/add")
    public ResponseEntity<?> add(@RequestBody EmailRequestDto emailRequestDto){
        emailService.add(emailRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
