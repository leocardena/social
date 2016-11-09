package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Title;

public interface TitleRepository 
	extends JpaRepository<Title, Long>{

}
