package com.projeto.surtr.dto.user;

import com.projeto.surtr.entities.User;
import com.projeto.surtr.services.UserService;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordUpdateRequest {

    @NotBlank
    private String password;

    public User updatePassword(Long id, UserService userService) {
        var user = userService.findById(id);
        user.setPassword(password);
        return user;
    }
}
