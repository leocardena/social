package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Season;

public interface SeasonTraktAPIBusiness {

	@PreAuthorize("permitAll")
	public List<Season> getSummarySeason(String id, String extended);
	
	@PreAuthorize("permitAll")
	public List<FirstAired> getAllSeasonPremieres(String start_date, int days, String extended, String query,
			String genres);

}
