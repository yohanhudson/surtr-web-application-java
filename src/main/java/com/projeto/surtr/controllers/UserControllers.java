package com.projeto.surtr.controllers;

import com.projeto.surtr.dto.user.PasswordUpdateRequest;
import com.projeto.surtr.dto.user.UserResponse;
import com.projeto.surtr.dto.user.UserResquest;
import com.projeto.surtr.dto.user.UserUpdateRequest;
import com.projeto.surtr.entities.User;
import com.projeto.surtr.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllers {

    private final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody @Valid UserResquest usersResquest) {
        User newUser = usersResquest.convertUser();
        return ResponseEntity.created(null).body(userService.register(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok().body(new UserResponse(user));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        var user = userUpdateRequest.updateUser(id, userService);
        return ResponseEntity.ok().body(new UserResponse(user));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity updatePassword(@PathVariable Long id, @RequestBody @Valid PasswordUpdateRequest passwordUpdateRequest) {
        var user = passwordUpdateRequest.updatePassword(id, userService);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
