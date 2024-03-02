package com.timirov.bankingtransactionsapi.repository;

import com.timirov.bankingtransactionsapi.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Integer countPhoneByUserId(Long id);

    Optional<Phone> findByPhone(String phone);
}
