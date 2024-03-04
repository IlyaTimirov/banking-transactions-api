package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.CreateUserDto;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.exception.UserAlreadyExistsException;
import com.timirov.bankingtransactionsapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public User findByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
    }
    public User create(CreateUserDto userRequestDto) {
        if(userRepository.findByUsername(userRequestDto.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(User.builder()
                .username(userRequestDto.getUsername())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .dateOfBirth(userRequestDto.getDateOfBirth())
                .fullName(userRequestDto.getFullName())
                .build());
    }
}
