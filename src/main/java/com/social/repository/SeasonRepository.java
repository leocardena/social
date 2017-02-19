package com.social.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.social.domain.Season;
import com.social.repository.custom.interfaces.SeasonBulkOperations;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>, SeasonBulkOperations {
	
	Optional<Season> findByNumber(Integer number);
}
