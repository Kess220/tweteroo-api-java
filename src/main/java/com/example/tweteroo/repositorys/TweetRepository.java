package com.example.tweteroo.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tweteroo.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findByUsername(String username);

    @Query("SELECT t FROM Tweet t ORDER BY t.id DESC LIMIT 5")
    List<Tweet> findTop5();

}
