package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.ResponseAPI;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Show;

public interface ShowTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Show>> getPopularShows(String page, String limit, String extended, String query,
			String genres);
	
	@PreAuthorize("permitAll")
	public Show getSummaryShow(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<Show> getShowTranslation(String id, String language, String extended);
	
	@PreAuthorize("permitAll")
	public List<Show> getRelatedShows(String id, String page, String limit, String extended);
	
	@PreAuthorize("permitAll")
	public List<FirstAired> getAllShows(String start_date, int days, String extended, String query, String genres);
	
	@PreAuthorize("permitAll")
	public List<FirstAired> getNewAllShows(String start_date, int days, String extended, String query, String genres);

}
