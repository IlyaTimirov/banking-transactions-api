package com.timirov.bankingtransactionsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Заполните имя пользователя!")
    private String username;

    @NotBlank(message = "Введите пароль!")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<Email> emails = new ArrayList<>();

    @NotNull(message = "Введите дату рождения!")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Введите Фамилию Имя Отчетсво (Иванов Иван Иванович)")
    private String fullName;

    @OneToOne
    private BankAccount bankAccount;

}
