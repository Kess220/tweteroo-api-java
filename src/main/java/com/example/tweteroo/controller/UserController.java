package com.example.tweteroo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweteroo.dto.UserDTO;
import com.example.tweteroo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/sing-up")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserDTO req) {
        service.create(req);
    }
}
