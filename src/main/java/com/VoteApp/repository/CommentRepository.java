package com.VoteApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VoteApp.domain.Comment;
import com.VoteApp.domain.Feature;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByFeature(Feature feature);
}
