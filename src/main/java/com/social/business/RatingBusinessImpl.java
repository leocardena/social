package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.RatingBusiness;
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
		
		UserRatingDTO u = new UserRatingDTO(ratingStoraged.getNote(), ratingStoraged.getId());
		return new PostResponseAPI<>("/api/rest/shows/" + showId + "/user-rating", u);
	}

	@Override
	public UserRatingDTO getUserRatingForTvShowBySlug(String slug) {
		Profile profile = accountBusiness.findProfileByLoggedUser();
		
		Optional<TvShow> tvShowOptional = tvShowBusiness.findBySlug(slug);
		
		if (!tvShowOptional.isPresent())
			throw new ResourceNotFoundException("Show nao encontrado");
		
		TvShow tvShow = tvShowOptional.get();
		
		Optional<Rating> ratingOptional = ratingRepository
				.findRatingByRatingParentAndProfile(profile.getId(), tvShow.getRatingParent().getId());
		
		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Usuario nao possui rating para o show");
		
		Rating rating = ratingOptional.get();
		
		return new UserRatingDTO(rating.getNote(), rating.getId());
	}

	@Override
	public void deleteRatingForTvShow(Long id) {
		findRatingById(id);
		ratingRepository.delete(id);
	}
	
	@Override
	public UserRatingDTO putRatingForTvShow(Long id, RatingVM ratingVM, String slug) {
		Optional<TvShow> tvShowOptional = tvShowBusiness.findBySlug(slug);
		
		if (!tvShowOptional.isPresent())
			throw new ResourceNotFoundException("Show nao encontrado");
		
		TvShow tvShow = tvShowOptional.get();
		
		Rating rating = findRatingById(id);
		
		if (tvShow.getRatingParent().getId() != rating.getIdRatingParent().getId())
			throw new ResourceNotFoundException("Rating nao encontrado para o show");
		
		rating.setDate(new DateTime());
		rating.setNote(ratingVM.getNote());
		
		Rating ratingUpdated = ratingRepository.save(rating);
		
		return new UserRatingDTO(ratingUpdated.getNote(), ratingUpdated.getId());
	}
	
	private Rating findRatingById(Long id) {
		Optional<Rating> ratingOptional = Optional.ofNullable(ratingRepository.findOne(id));
		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("O rating de id " + id + "nao foi encontrado");
		return ratingOptional.get();
	}
	
}
