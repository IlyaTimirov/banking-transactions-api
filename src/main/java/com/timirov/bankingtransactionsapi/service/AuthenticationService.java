package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.TokenResponseDto;
import com.timirov.bankingtransactionsapi.dto.UserRequestDto;
import com.timirov.bankingtransactionsapi.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomUserDetailsService customUserDetailsService;

    private final JwtTokenUtils jwtTokenUtils;

    private final AuthenticationManager authenticationManager;

    public TokenResponseDto authentication(UserRequestDto userRequestDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword()));
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userRequestDto.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return new TokenResponseDto(token);
    }
}
