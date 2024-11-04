package com.projeto.surtr.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String cpf;

    @Column
    private LocalDate birthDate;

    @Column
    private String password;

    public User() {
    }

    public User(String name, String email, String cpf, LocalDate birthDate, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.password = password;
    }
}
