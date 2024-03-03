package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.EmailDto;
import com.timirov.bankingtransactionsapi.dto.EmailRequestDto;
import com.timirov.bankingtransactionsapi.entity.Email;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.exception.email.EmailAlreadyExistsException;
import com.timirov.bankingtransactionsapi.exception.email.EmailLastException;
import com.timirov.bankingtransactionsapi.exception.email.EmailNotUserException;
import com.timirov.bankingtransactionsapi.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final static Integer EMAIL_LAST = 1;
    private final EmailRepository emailRepository;

    public void update(EmailRequestDto emailRequestDto, User user) {
        if(isContains(emailRequestDto.getId(), user)){
            emailRepository.save(Email.builder()
                    .id(emailRequestDto.getId())
                    .email(emailRequestDto.getEmail())
                    .user(user)
                    .build());
        } else {
            throw new EmailNotUserException();
        }
    }

    public void remove(Long id, User user){
        if(!isContains(id, user)){
            throw new EmailNotUserException();
        }
        if(emailRepository.countEmailByUserId(id).equals(EMAIL_LAST)){
            throw new EmailLastException();
        }
        emailRepository.deleteById(id);
    }

    public Email create(EmailDto emailDto, User user){
        if(emailRepository.findByEmail(emailDto.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException();
        }
        return emailRepository.save(Email.builder().email(emailDto.getEmail()).user(user).build());
    }

    public Email fetchById(Long id){
        return emailRepository.findById(id).orElseThrow();
    }

    private boolean isContains(Long id, User user){
        return user.getEmails().contains(fetchById(id));
    }
}
