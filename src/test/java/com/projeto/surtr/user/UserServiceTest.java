package com.projeto.surtr.user;

import com.projeto.surtr.entities.User;
import com.projeto.surtr.repositories.UserRepository;
import com.projeto.surtr.services.UserService;
import com.projeto.surtr.user.builder.UserBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Search by id when triggered with valid id should correctly return the employee")
    void SearchByIdWhenTriggeredWithValidIdShouldReturnCorrectUser() {

        Long id = 1L;
        User user = UserBuilder.createUser();
        when(userRepository.getReferenceById(Mockito.anyLong())).thenReturn(user);
        User newUser = userService.findById(id);

        assertNotNull(user);
        assertEquals(id, newUser.getId());
        assertEquals(user.getName(), newUser.getName());
        assertEquals(user.getEmail(), newUser.getEmail());
    }

    @Test
    @DisplayName("Creates an object of type User and registers it")
    void CreatesUserWhenTriggered() {

        Long id = 1L;
        User user = UserBuilder.createUser();
        User usercompared = UserBuilder.createUser();
        when(userRepository.save(Mockito.any(User.class))).thenReturn(usercompared);

        userService.register(user);
        Mockito.verify(userRepository).save(Mockito.any(User.class));
    }
}
