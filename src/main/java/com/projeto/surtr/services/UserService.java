package com.projeto.surtr.services;

import com.projeto.surtr.entities.User;
import com.projeto.surtr.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository usersRepository;

    public UserService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User register(User newUser) {
        return usersRepository.save(newUser);
    }

    public User findById(Long id) {
        return usersRepository.getReferenceById(id);
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }
}
