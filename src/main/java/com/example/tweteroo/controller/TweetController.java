package com.example.tweteroo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweteroo.dto.TweetDTO;
import com.example.tweteroo.dto.UserDTO;
import com.example.tweteroo.services.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping
    public void createTweet(@RequestBody TweetDTO tweetData) {
        tweetService.create(tweetData);
    }
}
