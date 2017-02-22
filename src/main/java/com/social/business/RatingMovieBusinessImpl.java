package com.social.business;

import java.util.Optional;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.applicationdiscovery.model.ResourceNotFoundException;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.MovieBusiness;
import com.social.business.interfaces.RatingMovieBusiness;
import com.social.domain.Movie;
import com.social.domain.Profile;
import com.social.domain.Rating;
import com.social.domain.RatingParent;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.web.rest.dto.UserRatingDTO;
import com.social.web.rest.response.PostResponseAPI;
import com.social.web.rest.vm.RatingVM;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class RatingMovieBusinessImpl implements RatingMovieBusiness {
	
	@Autowired
	private MovieBusiness movieBusiness;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private AccountBusiness accountBusiness;
	
	@Autowired
	private RatingParentRepository ratingParentRepository;
	
	@Override
	public PostResponseAPI<UserRatingDTO> postRatingForMovie(String movieId, TitleRatingVM titleRating) {

		Optional<Movie> movieOptional = movieBusiness.findBySlug(movieId);
		Movie movie;

		if (!movieOptional.isPresent()) {
			movie = movieBusiness.createMovie(titleRating, movieId);
		} else {
			movie = movieOptional.get();
		}
		
		if (movie.getRatingParent() == null) {
			RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
			movie.setRatingParent(ratingParent);
		}

		Profile profile = accountBusiness.findProfileByLoggedUser();

		Rating rating = new Rating();
		rating.setDate(new DateTime());
		rating.setNote(titleRating.getRating().getNote());
		rating.setProfile(profile.getId());
		rating.setIdRatingParent(movie.getRatingParent());

		Rating ratingStoraged = ratingRepository.save(rating);

		UserRatingDTO u = new UserRatingDTO(ratingStoraged.getNote());
		return new PostResponseAPI<>("/api/rest/shows/" + movieId + "/user-rating/" + ratingStoraged.getIdRating(), u);
		
	}

	@Override
	public UserRatingDTO putRatingForMovie(Long idRating, RatingVM ratingVM, String slug) {
		
		Optional<Movie> movieOptional = movieBusiness.findBySlug(slug);
		
		if(!movieOptional.isPresent())
			throw new ResourceNotFoundException("Movie não encontrado!");
		
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
		
		if(!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating não encontrado!");
		
		Rating rating = ratingOptional.get();
		rating.setDate(new DateTime());
		rating.setNote(ratingVM.getNote());

		Rating ratingUpdated = ratingRepository.save(rating);

		return new UserRatingDTO(ratingUpdated.getNote(), ratingUpdated.getIdRating());
		
	}

	@Override
	public void deleteRatingForMovie(Long idRating, String movieId) {

		Optional<Movie> movieOptional = movieBusiness.findBySlug(movieId);
		
		if(!movieOptional.isPresent())
			throw new ResourceNotFoundException("Movie não encontrado!");
		
		Optional<Rating> ratingOptional = ratingRepository.findRatingByIdRating(idRating);
		
		if(!ratingOptional.isPresent())
			throw new ResourceNotFoundException("Rating não encontrado!");
		
		ratingRepository.delete(ratingOptional.get());
		
	}

	@Override
	public UserRatingDTO getUserRatingForMovieBySlug(String slug, Long idRatingParent) {
		Profile profile = accountBusiness.findProfileByLoggedUser();
		Optional<Rating> ratingOptinal = ratingRepository.findUserRating(profile.getId(), idRatingParent, slug);

		if (!ratingOptinal.isPresent())
			throw new ResourceNotFoundException("Rating nao encontrado");

		Rating rating = ratingOptinal.get();

		return new UserRatingDTO(rating.getNote(), rating.getIdRating());
	}

}
