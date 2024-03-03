package com.timirov.bankingtransactionsapi.searchApi.service;

import com.timirov.bankingtransactionsapi.entity.User;
import com.timirov.bankingtransactionsapi.searchApi.dto.UserResponseDto;
import com.timirov.bankingtransactionsapi.searchApi.repository.SearchRepository;
import com.timirov.bankingtransactionsapi.searchApi.specification.UserSpecifications;
import com.timirov.bankingtransactionsapi.searchApi.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepository searchRepository;
    private final Mapper mapper;

    public List<UserResponseDto> searchUsers(LocalDate dateOfBirth, String phone, String fullName, String email, Pageable pageable) {
        Page<User> users = searchRepository.findAll(Specification
                .where(UserSpecifications.phoneContains(phone)
                        .or(UserSpecifications.emailContains(email))
                        .or(UserSpecifications.fullNameContains(fullName))
                        .or(UserSpecifications.dateOfBirthAfter(dateOfBirth))), pageable);
        return mapper.toDtos(users.getContent());
    }

}
