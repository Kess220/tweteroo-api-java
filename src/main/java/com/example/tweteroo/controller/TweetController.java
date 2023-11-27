package com.example.tweteroo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweteroo.dto.TweetDTO;
import com.example.tweteroo.models.Tweet;
import com.example.tweteroo.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public void createTweet(@RequestBody @Valid TweetDTO tweetData) {
        tweetService.create(tweetData);
    }

    @GetMapping
    public List<Tweet> getAll() {
        return tweetService.getTweets();
    }

    @GetMapping("/{username}")
    public List<Tweet> findByUsername(@PathVariable String username) {
        return tweetService.findByUsername(username);
    }
}
