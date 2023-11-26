package com.example.tweteroo.models;

import com.example.tweteroo.dto.UserDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    public User(UserDTO req) {
        this.username = req.username();
        this.avatar = req.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 70, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String avatar;

}
