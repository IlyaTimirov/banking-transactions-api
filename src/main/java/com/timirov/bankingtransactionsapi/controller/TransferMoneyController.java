package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.service.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferMoneyController {
    private final TransferMoneyService transferMoneyService;
}
