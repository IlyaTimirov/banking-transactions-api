package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.EmailDto;
import com.timirov.bankingtransactionsapi.dto.EmailRequestDto;
import com.timirov.bankingtransactionsapi.dto.PhoneRequestDto;
import com.timirov.bankingtransactionsapi.entity.Email;
import com.timirov.bankingtransactionsapi.entity.Phone;
import com.timirov.bankingtransactionsapi.exception.EmailLastException;
import com.timirov.bankingtransactionsapi.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final static Integer EMAIL_LAST = 1;
    private final EmailRepository emailRepository;

    public void add(EmailRequestDto emailRequestDto) {
        emailRepository.save(Email.builder()
                .email(emailRequestDto.getEmail())
                .user(null)
                .build());
    }

    public void update(EmailRequestDto emailRequestDto) {
        emailRepository.save(Email.builder()
                .id(emailRequestDto.getId())
                .email(emailRequestDto.getEmail())
                .user(null)
                .build());
    }

    public void remove(Long id){
        if(emailRepository.countEmailByUserId(id).equals(EMAIL_LAST)){
            throw new EmailLastException();
        }
        emailRepository.deleteById(id);
    }

    public Email create(EmailDto emailDto){
        return emailRepository.save(Email.builder().email(emailDto.getEmail()).user(emailDto.getUser()).build());
    }




}
