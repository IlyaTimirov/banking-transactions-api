package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.TokenResponseDto;
import com.timirov.bankingtransactionsapi.dto.UserRequestDto;
import com.timirov.bankingtransactionsapi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> authentication(@RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(authenticationService.authentication(userRequestDto), HttpStatus.OK);
    }
}
