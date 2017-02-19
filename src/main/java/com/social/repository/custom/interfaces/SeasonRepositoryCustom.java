package com.social.repository.custom.interfaces;

import java.util.Optional;
import com.social.domain.Season;

public interface SeasonRepositoryCustom {
	
	Optional<Season> findSeasonByNumberAndTvShowSlug(Integer seasonNumber, String slug);

}
