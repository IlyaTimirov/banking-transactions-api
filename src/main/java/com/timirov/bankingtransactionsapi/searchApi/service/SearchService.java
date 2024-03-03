package com.timirov.bankingtransactionsapi.searchApi.service;

import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.searchApi.repository.SearchRepository;
import com.timirov.bankingtransactionsapi.searchApi.specification.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;

    public Page<User> searchUsers(LocalDate dateOfBirth, String phone, String fullName, String email, Pageable pageable) {
        return searchRepository.findAll(Specification
                .where(UserSpecifications.phoneContains(phone)
                        .or(UserSpecifications.emailContains(email))
                        .or(UserSpecifications.fullNameContains(fullName))
                        .or(UserSpecifications.dateOfBirthAfter(dateOfBirth))), pageable);
    }

}
