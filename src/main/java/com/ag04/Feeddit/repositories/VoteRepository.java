package com.ag04.Feeddit.repositories;

import com.ag04.Feeddit.entities.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

    List<Vote> findByUserUsername(String username);
}
