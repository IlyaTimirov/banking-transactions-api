package com.timirov.bankingtransactionsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Заполните почту!")
    @jakarta.validation.constraints.Email(message = "Неккоретная почта (ivanov@mail.ru)")
    private String email;

    @ManyToOne
    private User user;
}
