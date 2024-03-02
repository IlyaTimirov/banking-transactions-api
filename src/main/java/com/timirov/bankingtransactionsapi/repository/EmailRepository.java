package com.timirov.bankingtransactionsapi.repository;

import com.timirov.bankingtransactionsapi.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    Integer countEmailByUserId(Long id);

    Optional<Email> findByEmail(String email);
}
