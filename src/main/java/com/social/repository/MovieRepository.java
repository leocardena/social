package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Movie;

public interface MovieRepository 
	extends JpaRepository<Movie, Long>{

	
}
