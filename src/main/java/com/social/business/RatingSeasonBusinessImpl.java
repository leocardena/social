package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.RatingSeasonBusiness;
import com.social.business.interfaces.TvShowBusiness;
import com.social.domain.CommentParent;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.RatingParent;
import com.social.domain.Season;
import com.social.domain.TvShow;
import com.social.repository.CommentParentRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.SeasonRepository;
import com.social.repository.TvShowRepository;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class RatingSeasonBusinessImpl implements RatingSeasonBusiness {

	@Autowired
	private TvShowRepository tvShowRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@Autowired
	private TvShowBusiness tvShowBusiness;

	@Autowired
	private CommentParentRepository commentParentRepository;

	@Autowired
	private RatingParentRepository ratingParentRepository;

	@Autowired
	private AccountBusiness accountBusiness;

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public PostResponseAPI<UserRatingDTO> postUserRatingForSeason(String showId, Integer seasonNumber,
			TitleRatingVM rating) {

		Optional<TvShow> tvShowOptional = tvShowRepository.findBySlug(showId);

		TvShow tvShow;
		if (!tvShowOptional.isPresent()) {
			tvShow = tvShowBusiness.createTvShow(rating, showId);
		} else {
			tvShow = tvShowOptional.get();
		}

		Optional<Season> seasonOptional = seasonRepository.findSeasonByNumberAndTvShowSlug(seasonNumber,
				tvShow.getSlug());

		if (!seasonOptional.isPresent())
			throw new ResourceNotFoundException("Season nao encontrada");

		Season season = seasonOptional.get();

		CommentParent commentParent;
		RatingParent ratingParent;

		if (season.getRatingParent() == null) {
			commentParent = commentParentRepository.saveAndFlush(new CommentParent());
			ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
			season.setCommentParent(commentParent);
			season.setRatingParent(ratingParent);
			seasonRepository.saveAndFlush(season);
		} else {
			commentParent = season.getCommentParent();
			ratingParent = season.getRatingParent();
		}

		Profile profile = accountBusiness.findProfileByLoggedUser().get();

		Rating userRating = new Rating();
		userRating.setDate(new DateTime());
		userRating.setIdRatingParent(ratingParent);
		userRating.setNote(rating.getRating().getNote());
		userRating.setProfile(profile.getId());
		userRating.setTargetType("SEASON");


		Rating ratingStored = ratingRepository.saveAndFlush(userRating);
		UserRatingDTO u = new UserRatingDTO(ratingStored.getNote());

		return new PostResponseAPI<UserRatingDTO>(
				"/api/rest/shows/" + showId + "/seasons/" + seasonNumber + "/user-ratings/" + ratingStored.getIdRating(),
				u);
	}

	@Override
	public UserRatingDTO putUserRatingForSeason(String showId, Integer seasonNumber, Long userRatingId,
			RatingVM ratingVM) {
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(userRatingId);

		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptional.get();

		rating.setDate(new DateTime());
		rating.setNote(ratingVM.getNote());

		Rating ratingUpdated = ratingRepository.save(rating);

		return new UserRatingDTO(ratingUpdated.getNote(), ratingUpdated.getIdRating());
	}

	@Override
	public void deleteUserRatingForSeason(String showId, Integer seasonNumber, Long userRatingId) {
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(userRatingId);

		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		ratingRepository.delete(ratingOptional.get());

	}

	@Override
	public UserRatingDTO getUserRatingForSeasonBySlug(String slug, Integer seasonNumber, Long idRatingParent) {
		Profile profile = accountBusiness.findProfileByLoggedUser().get();
		Optional<Rating> ratingOptinal = ratingRepository.findUserRating(profile.getId(), idRatingParent, slug);

		if (!ratingOptinal.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptinal.get();

		return new UserRatingDTO(rating.getNote(), rating.getIdRating());
	}

}
