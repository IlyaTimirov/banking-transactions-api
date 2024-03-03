package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.PhoneDto;
import com.timirov.bankingtransactionsapi.dto.PhoneRequestDto;
import com.timirov.bankingtransactionsapi.entity.Phone;
import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.exception.phone.PhoneAlreadyExistsException;
import com.timirov.bankingtransactionsapi.exception.phone.PhoneLastException;
import com.timirov.bankingtransactionsapi.exception.phone.PhoneNotUserException;
import com.timirov.bankingtransactionsapi.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final static Integer PHONE_LAST = 1;
    private final PhoneRepository phoneRepository;

    public void update(PhoneRequestDto phoneRequestDto, User user) {
        if(isContains(phoneRequestDto.getId(), user)){
            phoneRepository.save(Phone.builder()
                    .id(phoneRequestDto.getId())
                    .phone(phoneRequestDto.getPhone())
                    .user(user)
                    .build());
        } else {
            throw new PhoneNotUserException();
        }
    }

    public void remove(Long id, User user){
        if(!isContains(id, user)){
            throw new  PhoneNotUserException();
        }
        if(phoneRepository.countPhoneByUserId(id).equals(PHONE_LAST)){
            throw new PhoneLastException();
        }
        phoneRepository.deleteById(id);
    }

    public Phone create(PhoneDto phoneDto, User user){
        if(phoneRepository.findByPhone(phoneDto.getPhone()).isPresent()){
            throw new PhoneAlreadyExistsException();
        }
        return phoneRepository.save(Phone.builder().phone(phoneDto.getPhone()).user(user).build());
    }

    public Phone fetchById(Long id){
        return phoneRepository.findById(id).orElseThrow();
    }

    private boolean isContains(Long id, User user){
        return user.getPhones().contains(fetchById(id));
    }


}
