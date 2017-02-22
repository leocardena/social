package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Actor;

public interface ActorRepository extends 
	JpaRepository<Actor, Long>{

	Optional<Actor> findBySlug(String slug);
	
}
