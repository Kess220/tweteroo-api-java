package com.example.tweteroo.services;

import org.springframework.stereotype.Service;

import com.example.tweteroo.dto.UserDTO;
import com.example.tweteroo.exeption.UsernameAlreadyExistsException;
import com.example.tweteroo.models.User;
import com.example.tweteroo.repositorys.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void create(UserDTO data) {

        String username = data.username();
        if (repository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException("user already exist");
        }
        repository.save(new User(data));
    }
}
