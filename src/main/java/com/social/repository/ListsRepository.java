package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.domain.Lists;

public interface ListsRepository 
	extends JpaRepository<Lists, Long>{
	

}
