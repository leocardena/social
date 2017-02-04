package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.TvShow;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class RatingBusinessImpl implements RatingBusiness {
	
	@Autowired
	private TvShowBusiness tvShowBusiness;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private AccountBusiness accountBusiness;
	
	@Override
	public PostResponseAPI<UserRatingDTO> postRatingForTvShow(String showId, TitleRatingVM titleRating) {
		Optional<TvShow> tvShowOptional = tvShowBusiness.findBySlug(showId);
		TvShow tvShow;
		
		if (!tvShowOptional.isPresent()) {
			tvShow = tvShowBusiness.createTvShow(titleRating, showId);
		} else {
			tvShow = tvShowOptional.get();
		}
		
		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(titleRating.getRating().getNote());
		rating.setIdRatingParent(tvShow.getRatingParent());
		
		Profile profile = accountBusiness.findProfileByLoggedUser();
		rating.setProfile(profile.getId());
	
		Rating ratingStoraged = ratingRepository.save(rating);
		
		UserRatingDTO u = new UserRatingDTO();
		u.setNote(ratingStoraged.getNote());
		return new PostResponseAPI<>("/api/rest/shows/" + showId + "/user-rating", u);
	}

	@Override
	public void get(String showId) {
		// TODO Auto-generated method stub
		
	}
	
}
