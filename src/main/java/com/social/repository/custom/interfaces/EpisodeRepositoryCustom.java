package com.social.repository.custom.interfaces;

import java.util.Optional;
import com.social.domain.Episode;

public interface EpisodeRepositoryCustom {
	
	Optional<Episode> findEpisodeByNumberSeasonAndTvShowSlug(Integer seasonNumber, String slug, Integer episodeNumber);

}
