package com.example.tweteroo.models;

import org.hibernate.validator.constraints.URL;

import com.example.tweteroo.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tweets")
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO req, String avatar) {
        this.username = req.username();
        this.text = req.text();
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", length = 255, nullable = false)
    private String text;

    @Column(length = 20)
    @NotNull
    private String username;

    @Column(length = 100, nullable = false)
    @NotNull
    @URL
    private String avatar;

}
