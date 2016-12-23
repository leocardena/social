package com.social.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;
import com.social.domain.Movie;
import com.social.domain.QMovie;
import com.social.repository.MovieRepository;

@Service
public class MovieBusiness {

	@Autowired
	private EntityManager entity;
//	@Autowired
//	private static final JPAQuery query = new JPAQuery(entity);
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Long id){
		JPAQuery query = new JPAQuery(entity);
		
		Movie result = query.from(QMovie.movie)
				.where(QMovie.movie.id.eq(id))
				.singleResult(QMovie.movie);
		
		return result;
	}

	public Movie getMovieByName(String name){
		JPAQuery query = new JPAQuery(entity);
		
		Movie result = query.from(QMovie.movie)
				.where(QMovie.movie.name.eq(name))
				.singleResult(QMovie.movie);
		
		return result;
	}
	
	public List<Movie> getAllMoviesByName(String name){
		JPAQuery query = new JPAQuery(entity);
		
		List<Movie> results = query.from(QMovie.movie)
				.where(QMovie.movie.name.eq(name))
				.list(QMovie.movie);
		
		return results;
	}

	
}
