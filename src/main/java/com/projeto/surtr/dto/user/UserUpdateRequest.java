package com.projeto.surtr.dto.user;

import com.projeto.surtr.entities.User;
import com.projeto.surtr.services.UserService;
import com.projeto.surtr.utils.AgeRange;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserUpdateRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotBlank
    private String email;

    @AgeRange(minAge = 18)
    private LocalDate birthDate;

    public User updateUser(Long id, UserService userServicer) {
        var user = userServicer.findById(id);
        user.setName(name);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        return user;
    }
}
