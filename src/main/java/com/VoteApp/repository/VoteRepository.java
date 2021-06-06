package com.VoteApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VoteApp.domain.Vote;
import com.VoteApp.domain.VoteId;

public interface VoteRepository extends JpaRepository<Vote, VoteId> {
 
 
}
