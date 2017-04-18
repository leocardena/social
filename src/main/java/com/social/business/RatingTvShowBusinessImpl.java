package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.RatingTvShowBusiness;
import com.social.business.interfaces.TvShowBusiness;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.TvShow;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class RatingTvShowBusinessImpl implements RatingTvShowBusiness {
	
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

		Profile profile = accountBusiness.findProfileByLoggedUser().get();

		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(titleRating.getRating().getNote());
		rating.setProfile(profile.getId());
		rating.setIdRatingParent(tvShow.getRatingParent());
		rating.setTargetType("TVSHOW");

		Rating ratingStoraged = ratingRepository.save(rating);

		UserRatingDTO u = new UserRatingDTO(ratingStoraged.getNote());
		return new PostResponseAPI<>("/api/rest/shows/" + showId + "/user-rating/" + ratingStoraged.getIdRating(), u);
	}

	@Override
	public UserRatingDTO getUserRatingForTvShowBySlug(String slug, Long idRatingParent) {
		Profile profile = accountBusiness.findProfileByLoggedUser().get();
		Optional<Rating> ratingOptinal = ratingRepository.findUserRating(profile.getId(), idRatingParent, slug);

		if (!ratingOptinal.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptinal.get();

		return new UserRatingDTO(rating.getNote(), rating.getIdRating());
	}

	@Override
	public void deleteRatingForTvShow(Long idRating, String showId) {
		Optional<TvShow> tvShowOptional = tvShowBusiness.findBySlug(showId);

		if (!tvShowOptional.isPresent())
			throw new ResourceNotFoundException("Show nao encontrado");
		
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
			
		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");
		
		ratingRepository.delete(ratingOptional.get());
	}

	@Override
	public UserRatingDTO putRatingForTvShow(Long idRating, RatingVM ratingVM, String slug) {
		Optional<TvShow> tvShowOptional = tvShowBusiness.findBySlug(slug);

		if (!tvShowOptional.isPresent())
			throw new ResourceNotFoundException("Show nao encontrado");

		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
		
		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptional.get();

		rating.setDate(new DateTime());
		rating.setNote(ratingVM.getNote());

		Rating ratingUpdated = ratingRepository.save(rating);

		return new UserRatingDTO(ratingUpdated.getNote(), ratingUpdated.getIdRating());
	}

}
