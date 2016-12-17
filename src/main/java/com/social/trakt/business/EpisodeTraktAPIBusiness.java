package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Episode;

public interface EpisodeTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Episode getSummaryEpisode(String id, int season, int episode, String extended);
	
	@PreAuthorize("permitAll")
	public List<Episode> getEpisodeForSeason(String id, int season, String extended);

}
