package com.social.tmdb.business;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.model.Movie;
import com.social.tmdb.model.MoviePagination;
import com.social.tmdb.services.MovieTmdbAPIService;
import com.social.tmdb.util.ConfigurationTmdbAPIConnection;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class MovieTmdbAPIBusiness {

	@Autowired
	private MovieTmdbAPIService movieTmdbAPIService;
	
	@Autowired
	private ConfigurationTmdbAPIConnection config;
	
	public Movie getPopularRandomMovie(String size) {
		Call<MoviePagination> call = movieTmdbAPIService.getPopularMovies();
		Call<MoviePagination> callClone = call.clone();
		Response<MoviePagination> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			MoviePagination movieResponse = resp.body();
			List<Movie> movies = movieResponse.getMovies();
			Random randomizer = new Random();
			Movie movie = movies.get(randomizer.nextInt(movies.size()));
			String backdropPath = config.getImageURL(size, movie.getBackdropPath());
			movie = new Movie();
			movie.setBackdropPath(backdropPath);
			return movie;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
