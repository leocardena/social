package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.social.domain.Season;
import com.social.repository.custom.interfaces.SeasonBulkOperations;
import com.social.repository.custom.interfaces.SeasonRepositoryCustom;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>, SeasonBulkOperations, SeasonRepositoryCustom {
	
}
