package com.social.tmdb.business;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.model.Movie;
import com.social.tmdb.model.MovieResponse;
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
	
	public String getPopularRandomMovie(String size) {
		Call<MovieResponse> call = movieTmdbAPIService.getPopularMovies();
		Call<MovieResponse> callClone = call.clone();
		Response<MovieResponse> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			MovieResponse movieResponse = resp.body();
			List<Movie> movies = movieResponse.getMovies();
			Random randomizer = new Random();
			Movie movie = movies.get(randomizer.nextInt(movies.size()));
			return config.getImageURL(size, movie.getBackdropPath());
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
