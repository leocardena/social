package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Episode;

public interface EpisodeTraktAPIBusiness {

	@PreAuthorize("permitAll")
	public Episode getSummaryEpisode(String showId, String seasonNumber, String episodeNumber, String extended);

	@PreAuthorize("permitAll")
	public List<Episode> getTranslationsForAEpisode(String showId, String seasonNumber, String episodeNumber,
			String language);

}