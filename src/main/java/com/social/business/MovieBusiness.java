package com.social.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQuery;
import com.social.domain.Movie;
import com.social.domain.QMovie;
import com.social.repository.MovieRepository;
import com.social.repository.RatingRepository;

@Service
public class MovieBusiness {

	@Autowired
	private EntityManager entity;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Long id){
		JPAQuery<?> query = new JPAQuery<Void>(entity);
		
		Movie result = query.select(QMovie.movie)
				.where(QMovie.movie.id.eq(id)).
				fetchOne();
		
		return result;
	}

	public Movie getMovieByName(String name){
		JPAQuery<?> query = new JPAQuery<Void>(entity);
		
		Movie result = query.select(QMovie.movie)
				.where(QMovie.movie.name.eq(name))
				.fetchOne();
		
		return result;
	}
	
	public List<Movie> getAllMoviesByName(String name){
		JPAQuery<?> query = new JPAQuery<Void>(entity);
		
		List<Movie> results = query.select(QMovie.movie)
				.where(QMovie.movie.name.eq(name)).
				fetch();
		
		return results;
	}

	public long getAvgRatingById(Long idRatingParent){
		return ratingRepository.avgByIdRatingParent(idRatingParent);
	}
	
	
}
