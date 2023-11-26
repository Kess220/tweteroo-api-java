package com.example.tweteroo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tweteroo.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
