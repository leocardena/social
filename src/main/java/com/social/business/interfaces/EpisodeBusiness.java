package com.social.business.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import com.social.web.rest.dto.EpisodeDTO;

public interface EpisodeBusiness {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	EpisodeDTO getEpisode(Integer seasonNumber, String showId, Integer episodeNumber);
	
}
