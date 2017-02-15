package com.social.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Movie;

public interface MovieRepository 
	extends JpaRepository<Movie, Long>{

	Optional<Movie> findBySlug(String slug);
	
}
