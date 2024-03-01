package com.timirov.bankingtransactionsapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany
    private List<Phone> phones = new ArrayList<>();

    @OneToMany
    private List<Email> emails = new ArrayList<>();

    private LocalDate dateOfBirth;

    private String fullName;

    @OneToOne
    private BankAccount bankAccount;

}
