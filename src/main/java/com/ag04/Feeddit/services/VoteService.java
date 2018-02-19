package com.ag04.Feeddit.services;

import com.ag04.Feeddit.entities.Article;
import com.ag04.Feeddit.entities.Vote;
import com.ag04.Feeddit.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public void save(Vote newVote) {
        voteRepository.save(newVote);
    }

    public List<Vote> findByUsername(String username) {

        List<Vote> votes = new ArrayList<>();

        votes.addAll(voteRepository.findByUserUsername(username));
        return votes;
    }

    public boolean existsByUsernameAndArticleId(String username, int articleId){
        return findByUsername(username).stream()
                .anyMatch(tempVote -> tempVote.getArticle().getId() == articleId);
    }

    public Vote getVoteByUsernameAndArticleId(String username, int articleId){

        return findByUsername(username).stream()
                .filter(tempVote -> tempVote.getArticle().getId() == articleId)
                .findFirst()
                .orElse(null);
    }
}
