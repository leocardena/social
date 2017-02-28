package com.social.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.social.domain.Episode;
import com.social.repository.custom.interfaces.EpisodeBulkOperations;
import com.social.repository.custom.interfaces.EpisodeRepositoryCustom;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long>, EpisodeBulkOperations, EpisodeRepositoryCustom {
	
	Optional<Episode> findByNumber(Integer number);
	
}
