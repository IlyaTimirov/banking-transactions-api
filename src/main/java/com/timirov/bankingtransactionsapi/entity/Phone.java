package com.timirov.bankingtransactionsapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Заполните номер!")
    @Pattern(regexp = "\\d{10}", message = "Номер телефона должен состоять из 10 фицр!")
    private String phone;

    @ManyToOne
    private User user;
}
