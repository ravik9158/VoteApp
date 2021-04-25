package com.VoteApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VoteApp.domain.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
