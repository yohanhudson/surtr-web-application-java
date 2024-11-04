package com.projeto.surtr.dto.user;

import com.projeto.surtr.entities.User;
import com.projeto.surtr.utils.AgeRange;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResquest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @AgeRange(minAge = 18)
    private LocalDate birthDate;

    @NotBlank
    private String password;

    public User convertUser() {
        return new User(name, email, cpf, birthDate, password);
    }
}
