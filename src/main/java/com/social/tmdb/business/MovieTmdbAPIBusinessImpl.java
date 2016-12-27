package com.social.tmdb.business;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.exception.TMDBImageNotFound;
import com.social.tmdb.model.Backdrop;
import com.social.tmdb.model.Images;
import com.social.tmdb.model.Movie;
import com.social.tmdb.model.MoviePagination;
import com.social.tmdb.model.Poster;
import com.social.tmdb.services.MovieTmdbAPIService;
import com.social.tmdb.util.ConfigurationTmdbAPIConnection;
import com.social.tmdb.util.TmdbImagesUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class MovieTmdbAPIBusinessImpl implements MovieTmdbAPIBusiness{

	@Autowired
	private MovieTmdbAPIService movieTmdbAPIService;

	@Autowired
	private ConfigurationTmdbAPIConnection config;
	
	@Override
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
	
	@Override
	public Map<String, Object> getMovieImages(String movieId, String backdropSize, String posterSize, String language) {
		Call<Images> call = movieTmdbAPIService.getMovieImages(movieId, language, "pt,en,null");
		Call<Images> callClone = call.clone();
		Response<Images> resp;
		try {
			resp = callClone.execute();
			if (resp.code() == 404)
				throw new TMDBImageNotFound("A imagem não foi encontrada na API TMDB");
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			Images images = resp.body();
			Backdrop backdrop = TmdbImagesUtil.getFirstBackDropFromImages(images);
			Poster poster = TmdbImagesUtil.getFirstPosterFromImages(images);
			if (backdrop.getFilePath() != null) backdrop.setFilePath(config.getImageURL(backdropSize, backdrop.getFilePath()));
			if (poster.getFilePath() != null) poster.setFilePath(config.getImageURL(posterSize, poster.getFilePath()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("backdrop", backdrop);
			map.put("poster", poster);
			return map;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
