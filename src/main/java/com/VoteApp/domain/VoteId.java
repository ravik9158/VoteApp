package com.VoteApp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VoteId implements Serializable{

	private static final long serialVersionUID = 8425524285583938852L;
	private User user;
	private Feature features;
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	public Feature getFeatures() {
		return features;
	}
	public void setFeatures(Feature features) {
		this.features = features;
	}
	
	
}
