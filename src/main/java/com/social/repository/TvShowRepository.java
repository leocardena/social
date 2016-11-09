package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.TvShow;

public interface TvShowRepository 
	extends JpaRepository<TvShow, Long>{
}
