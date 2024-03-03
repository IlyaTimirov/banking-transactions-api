package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.EmailDto;
import com.timirov.bankingtransactionsapi.dto.EmailRequestDto;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.service.EmailService;
import com.timirov.bankingtransactionsapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    private final UserService userService;

    private User getUser(Principal principal){
        return userService.findByUsername(principal.getName());
    }

    @PostMapping("/email/add")
    public ResponseEntity<?> add(@RequestBody @Valid EmailRequestDto emailRequestDto, Principal principal){
        emailService.create(new EmailDto(emailRequestDto.getEmail()), getUser(principal));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/email/update")
    public ResponseEntity<?> update(@RequestBody EmailRequestDto emailRequestDto, Principal principal){
        emailService.update(emailRequestDto, getUser(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/email/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id, Principal principal){
        emailService.remove(id, getUser(principal));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
