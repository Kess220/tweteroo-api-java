package com.example.tweteroo.services;

import org.springframework.stereotype.Service;

import com.example.tweteroo.dto.TweetDTO;
import com.example.tweteroo.models.Tweet;
import com.example.tweteroo.models.User;
import com.example.tweteroo.repositorys.TweetRepository;
import com.example.tweteroo.repositorys.UserRepository;

@Service
public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void create(TweetDTO tweetData) {
        User user = userRepository.findByUsername(tweetData.username());
        Tweet tweet = new Tweet(tweetData.text(), user);
        tweetRepository.save(tweet);
    }

}
