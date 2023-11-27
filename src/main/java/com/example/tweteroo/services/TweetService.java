package com.example.tweteroo.services;

import java.util.List;

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
        tweetRepository.save(new Tweet(tweetData, user.getAvatar()));
    }

    public List<Tweet> findByUsername(String username) {
        return tweetRepository.findByUsername(username);
    }

    public List<Tweet> getTweets() {
        // * */ Ordena por ID em ordem decrescente
        return tweetRepository.findTop5();
    }
}
