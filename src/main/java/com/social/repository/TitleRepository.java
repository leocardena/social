package com.social.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.social.domain.Title;

public interface TitleRepository extends JpaRepository<Title, Long>{
	
	Optional<Title> findBySlug(String slug);

}
