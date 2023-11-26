package com.example.tweteroo.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
        @NotBlank String username,
        @NotBlank String text) {

}
