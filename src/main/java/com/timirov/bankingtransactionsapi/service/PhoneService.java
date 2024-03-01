package com.timirov.bankingtransactionsapi.service;

import com.timirov.bankingtransactionsapi.dto.PhoneDto;
import com.timirov.bankingtransactionsapi.dto.PhoneRequestDto;
import com.timirov.bankingtransactionsapi.entity.Phone;
import com.timirov.bankingtransactionsapi.exception.PhoneLastException;
import com.timirov.bankingtransactionsapi.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final static Integer PHONE_LAST = 1;
    private final PhoneRepository phoneRepository;

    public void add(PhoneRequestDto phoneRequestDto) {
        phoneRepository.save(Phone.builder()
                .phone(phoneRequestDto.getPhone())
                .user(null)
                .build());
    }

    public void update(PhoneRequestDto phoneRequestDto) {
        phoneRepository.save(Phone.builder()
                .phone(phoneRequestDto.getPhone())
                .build());
    }

    public void remove(Long id) {
        if (phoneRepository.countPhoneByUserId(id).equals(PHONE_LAST)) {
            throw new PhoneLastException();
        }
        phoneRepository.deleteById(id);
    }

    public Phone create(PhoneDto phoneDto) {
        return phoneRepository.save(Phone.builder()
                .phone(phoneDto.getPhone())
                .user(phoneDto.getUser())
                .build());
    }


}
