package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.TransferMoneyDto;
import com.timirov.bankingtransactionsapi.service.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TransferMoneyController {
    private final TransferMoneyService transferMoneyService;

    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody TransferMoneyDto transferMoneyDto, Principal principal){
        return new ResponseEntity<>(transferMoneyService.transferMoneyId(transferMoneyDto, principal.getName()), HttpStatus.OK);
    }
}
