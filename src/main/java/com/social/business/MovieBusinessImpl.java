package com.social.business;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.MovieBusiness;
import com.social.domain.CommentParent;
import com.social.domain.Movie;
import com.social.domain.RatingParent;
import com.social.repository.CommentParentRepository;
import com.social.repository.MovieRepository;
import com.social.repository.RatingParentRepository;
import com.social.repository.RatingRepository;
import com.social.repository.dto.RatingQueryDTO;
import com.social.web.rest.dto.MovieDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.vm.TitleRatingVM;

@Service
public class MovieBusinessImpl implements MovieBusiness {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RatingRepository ratingRepository;
	@Autowired
	private RatingParentRepository ratingParentRepository;
	@Autowired
	private CommentParentRepository commentParentRepository;
		
	@Override
	public MovieDTO getMovie(String id) {
		
		Optional<Movie> movieOptinal = findBySlug(id);
		
		if(!movieOptinal.isPresent()) 
			throw new ResourceNotFoundException("Show nao encontrado");
		
		Movie movie = movieOptinal.get();
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setId(movie.getId());
		movieDTO.setImdb(movie.getImdb());
		movieDTO.setName(movie.getName());
		movieDTO.setSlug(movie.getSlug());
		movieDTO.setTrailer(movie.getTrailer());
		movieDTO.setHomePage(movie.getHomePage());
		
		Optional<RatingQueryDTO> ratingQueryDTOOptional = ratingRepository
				.averageByIdRatingParent(movie.getRatingParent().getId());
		
		if (ratingQueryDTOOptional.isPresent()) {
			RatingQueryDTO ratingQueryDTO = ratingQueryDTOOptional.get();
			movieDTO.setNoteAverage(ratingQueryDTO.getAverage());
			movieDTO.setVotes(ratingQueryDTO.getVotes());
		}
		
		return movieDTO;
	}

	@Override
	public Movie createMovie(TitleRatingVM titleRating, String slug) {

		RatingParent ratingParent = ratingParentRepository.saveAndFlush(new RatingParent());
		CommentParent commentParent = commentParentRepository.saveAndFlush(new CommentParent());

		Movie movie = new Movie();
		movie.setHomePage(titleRating.getHomePage());
		movie.setImdb(titleRating.getImdb());
		movie.setName(titleRating.getName());
		movie.setSlug(slug);
		movie.setTrailer(titleRating.getTrailer());
		movie.setCommentParent(commentParent);
		movie.setRatingParent(ratingParent);
		
		return movieRepository.saveAndFlush(movie);
	}

	@Override
	public Optional<Movie> findBySlug(String slug) {
		return movieRepository.findBySlug(slug);
	}
	

}
