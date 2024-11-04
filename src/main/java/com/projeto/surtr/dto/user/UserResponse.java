package com.projeto.surtr.dto.user;

import com.projeto.surtr.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private LocalDate birthDate;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
    }
}
