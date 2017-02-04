package com.social.business;

import java.util.Optional;
import com.social.domain.TvShow;
import com.social.web.rest.vm.TitleRatingVM;

public interface TvShowBusiness {
	
	TvShow createTvShow(TitleRatingVM titleRating, String showId);
	Optional<TvShow> findBySlug(String slug);
	
}
