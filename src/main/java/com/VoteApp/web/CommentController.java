package com.VoteApp.web;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.VoteApp.domain.Comment;
import com.VoteApp.domain.Feature;
import com.VoteApp.domain.User;
import com.VoteApp.repository.CommentRepository;
import com.VoteApp.service.FeatureService;

@Controller
@RequestMapping("/products/{productId}/features/{featureId}/comments")
public class CommentController {

	@Autowired
	public CommentRepository commentRepo;
	
	@Autowired
	public FeatureService featureService;
	
	@PostMapping("")
	public String postComment(@AuthenticationPrincipal User user, @PathVariable Long featureId, @PathVariable Long productId, Comment newComment) {
		Optional<Feature> feature = featureService.findById(featureId);
		if(feature.isPresent()) {
			newComment.setFeature(feature.get());
			newComment.setUser(user);
			newComment.setCreatedDate(new Date());
			commentRepo.save(newComment);
		}
		
		return "redirect:/products/"+productId+ "/features/"+ featureId;
	}
}
