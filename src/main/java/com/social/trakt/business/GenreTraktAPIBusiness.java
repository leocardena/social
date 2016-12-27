package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.trakt.model.Genre;

public interface GenreTraktAPIBusiness {
	
	@PreAuthorize("permitAll")
	public List<Genre> getListGenres(String type);

}
