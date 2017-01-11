package com.social.business;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.social.domain.Movie;
import com.social.domain.QMovie;
import com.social.repository.MovieRepository;
import com.social.repository.RatingRepository;

import retrofit2.Call;

@Service
public class MovieBusinessImpl implements MovieBusiness {

	@Autowired
	private EntityManager entity;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
		
	@Override
	public Movie getMovieById(Long id){
		JPAQueryFactory query = new JPAQueryFactory(entity);
		
		Movie result = query.select(QMovie.movie)
				.where(QMovie.movie.id.eq(id))
				.fetchOne();
		
		return result;
	}

	@Override
	public Movie getMovieByName(String name){
		//VERIFICAR JPAQueryFactory para JPAQuery (diference)
		JPAQueryFactory query = new JPAQueryFactory(entity);
		
		Movie result = query.selectFrom(QMovie.movie)
				.where(QMovie.movie.name.eq(name))
				.fetchFirst();
		
		return result;
	}
	
	@Override
	public List<Movie> getAllMoviesByName(String name){
		JPAQueryFactory query = new JPAQueryFactory(entity);
		
		List<Movie> results = query.select(QMovie.movie)
				.where(QMovie.movie.name.eq(name)).
				fetch();
		
		return results;
	}

	@Override
	public long getAvgRatingById(Long idRatingParent){
		return ratingRepository.avgByIdRatingParent(idRatingParent);
	}
	
}
