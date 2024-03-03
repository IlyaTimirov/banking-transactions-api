package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.CreateUserDto;
import com.timirov.bankingtransactionsapi.entity.BankAccount;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.service.CreateUserService;
import com.timirov.bankingtransactionsapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final CreateUserService createUserService;
    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid CreateUserDto createUserDto){
        createUserService.createNewUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
