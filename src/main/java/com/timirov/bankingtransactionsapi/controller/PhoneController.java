package com.timirov.bankingtransactionsapi.controller;

import com.timirov.bankingtransactionsapi.dto.PhoneDto;
import com.timirov.bankingtransactionsapi.dto.PhoneRequestDto;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.service.PhoneService;
import com.timirov.bankingtransactionsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
public class PhoneController {
    private final PhoneService phoneService;

    private final UserService userService;

    private User getUser(Principal principal){
        return userService.findByUsername(principal.getName());
    }

    @PostMapping("/phone/add")
    public ResponseEntity<?> add(@RequestBody PhoneRequestDto phoneRequestDto, Principal principal){
        phoneService.create(new PhoneDto(phoneRequestDto.getPhone()), getUser(principal));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/phone/update")
    public ResponseEntity<?> update(@RequestBody PhoneRequestDto phoneRequestDto, Principal principal){
        phoneService.update(phoneRequestDto, getUser(principal));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/phone/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id, Principal principal){
        phoneService.remove(id, getUser(principal));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
