package com.timirov.bankingtransactionsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Заполните имя пользователя!")
    private String username;

    @NotBlank(message = "Введите пароль!")
    private String password;

    @OneToMany
    private List<Phone> phones = new ArrayList<>();

    @OneToMany
    private List<Email> emails = new ArrayList<>();

    @NotBlank(message = "Введите дату рождения!")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Введите Фамилию Имя Отчетсво (Иванов Иван Иванович)")
    private String fullName;

    @OneToOne
    private BankAccount bankAccount;

}
