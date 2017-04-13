package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.TvShowBusiness;
import com.social.domain.CommentParent;
import com.social.domain.Episode;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.RatingParent;
import com.social.domain.TvShow;
import com.social.repository.CommentParentRepository;
import com.social.repository.EpisodeRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.TvShowRepository;
import com.social.trakt.business.interfaces.ShowTraktAPIBusiness;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.EpisodeRatingVM;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class RatingEpisodeBusiness implements com.social.business.interfaces.RatingEpisodeBusiness {

	@Autowired
	private TvShowRepository tvShowRepository;

	@Autowired
	private TvShowBusiness tvShowBusiness;

	@Autowired
	private ShowTraktAPIBusiness showTraktAPIBusiness;

	@Autowired
	private EpisodeRepository episodeRepository;

	@Autowired
	private CommentParentRepository commentParentRepository;

	@Autowired
	private RatingParentRepository ratingParentRepository;

	@Autowired
	private AccountBusiness accountBusiness;

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public PostResponseAPI<UserRatingDTO> postUserRatingForEpisode(String showId, Integer seasonNumber,
			Integer episodeNumber, EpisodeRatingVM rating) {

		Optional<TvShow> tvShowOptional = tvShowRepository.findBySlug(showId);

		TvShow tvShow;
		if (!tvShowOptional.isPresent()) {
			com.social.trakt.model.Show tvShowTrakt = showTraktAPIBusiness.getSummaryShow(showId, "extended");
			TitleRatingVM tr = new TitleRatingVM();
			tr.setHomePage(tvShowTrakt.getHomepage() != null ? tvShowTrakt.getHomepage() : null);
			tr.setImdb(tvShowTrakt.getIds().getImdb() != null ? tvShowTrakt.getIds().getImdb() : null);
			tr.setName(tvShowTrakt.getTitle() != null ? tvShowTrakt.getTitle() : null);
			tr.setTrailer(tvShowTrakt.getTrailer() != null ? tvShowTrakt.getTrailer() : null);
			tvShow = tvShowBusiness.createTvShow(tr, showId);
		} else {
			tvShow = tvShowOptional.get();
		}

		Optional<Episode> episodeOptinal = episodeRepository.findEpisodeByNumberSeasonAndTvShowSlug(seasonNumber,
				tvShow.getSlug(), episodeNumber);

		if (!episodeOptinal.isPresent())
			throw new ResourceNotFoundException("Season nao encontrada");

		Episode episode = episodeOptinal.get();

		CommentParent commentParent;
		RatingParent ratingParent;

		if (episode.getRatingParent() == null) {
			commentParent = commentParentRepository.saveAndFlush(new CommentParent());
			ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
			episode.setCommentParent(commentParent);
			episode.setRatingParent(ratingParent);
			episode.setName(rating.getName() != null ? rating.getName() : null);
			episodeRepository.saveAndFlush(episode);
		} else {
			commentParent = episode.getCommentParent();
			ratingParent = episode.getRatingParent();
		}

		Profile profile = accountBusiness.findProfileByLoggedUser().get();

		Rating userRating = new Rating();
		userRating.setDate(new DateTime());
		userRating.setIdRatingParent(ratingParent);
		userRating.setNote(rating.getRating().getNote());
		userRating.setProfile(profile.getId());

		Rating ratingStored = ratingRepository.saveAndFlush(userRating);
		UserRatingDTO u = new UserRatingDTO(ratingStored.getNote());

		String href = "/api/rest/shows/" + showId + "/seasons/" + seasonNumber + "/episodes/" + episodeNumber
				+ "/user-ratings/" + ratingStored.getIdRating();

		return new PostResponseAPI<UserRatingDTO>(href, u);
	}

	@Override
	public UserRatingDTO putUserRatingForEpisode(String showId, Integer seasonNumber, Long userRatingId,
			Integer episodeNumber, RatingVM ratingVM) {
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
	public void deleteUserRatingForEpisode(String showId, Integer seasonNumber, Integer episodeNumber,
			Long userRatingId) {
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(userRatingId);

		if (!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		ratingRepository.delete(ratingOptional.get());

	}

	@Override
	public UserRatingDTO getUserRatingForEpisode(String slug, Integer seasonNumber, Integer episodeNumber,
			Long idRatingParent) {
		Profile profile = accountBusiness.findProfileByLoggedUser().get();
		Optional<Rating> ratingOptinal = ratingRepository.findUserRating(profile.getId(), idRatingParent, slug);

		if (!ratingOptinal.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptinal.get();

		return new UserRatingDTO(rating.getNote(), rating.getIdRating());
	}

}
