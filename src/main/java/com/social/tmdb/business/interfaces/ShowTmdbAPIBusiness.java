package com.social.tmdb.business.interfaces;

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.tmdb.model.Poster;
import com.social.tmdb.model.Show;
import com.social.tmdb.model.Still;

public interface ShowTmdbAPIBusiness {
	
	@PreAuthorize("permitAll")
	public Show getPopularRandomShow(String size);
	
	@PreAuthorize("permitAll")
	public Map<String, Object> getShowImages(String showId, String backdropSize, String posterSize, String language);
	
	@PreAuthorize("permitAll")
	public Poster getSeasonImages(String showId, String posterSize, String language, String seasonNumber);
	
	@PreAuthorize("permitAll")
	public Still getEpisodeImages(String showId, String stillSize, String episodeNumber, String seasonNumber);

}
