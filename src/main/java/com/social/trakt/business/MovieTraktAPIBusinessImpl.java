package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.social.domain.ResponseAPI;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Movie;
import com.social.trakt.model.Released;
import com.social.trakt.services.MovieTraktAPIService;
import com.social.web.rest.util.PaginationUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class MovieTraktAPIBusinessImpl implements MovieTraktAPIBusiness {

	@Autowired
	private MovieTraktAPIService movieAPIService;
	
	@Override
	public ResponseAPI<List<Movie>> getPopularMovies(String page, String limit, String extended, String query,
			String genres) {
		Call<List<Movie>> call = movieAPIService.getPopularMovies(page, limit, extended, query, genres);
		Call<List<Movie>> callClone = call.clone();
		Response<List<Movie>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			List<Movie> movies = resp.body();
			HttpHeaders headers = PaginationUtil.getHeadersFromTraktResponse(resp.headers());
			ResponseAPI<List<Movie>> responseAPI = new ResponseAPI<>();
			responseAPI.setHeaders(headers);
			responseAPI.setBody(movies);
			return responseAPI;
		} catch (IOException e) {
			 throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public Movie getSummaryMovie(String id, String extended) {
		Call<Movie> call = movieAPIService.getSummaryMovie(id, extended);
		Call<Movie> callClone = call.clone();
		Response<Movie> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<Movie> getMovieTranslation(String id, String language, String extended) {
		Call<List<Movie>> call = movieAPIService.getMovieTranslation(id, language, extended);
		Call<List<Movie>> callClone = call.clone();
		Response<List<Movie>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<Movie> getRelatedMovies(String id, String page, String limit, String extended) {
		Call<List<Movie>> call = movieAPIService.getRelatedMovies(id, page, limit, extended);
		Call<List<Movie>> callClone = call.clone();
		Response<List<Movie>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	@Override
	public List<Released> getAllMovies(String start_date, int days, String extended, String query, String genres) {
		Call<List<Released>> call = movieAPIService.getAllMovies(start_date, days, extended, query, genres);
		Call<List<Released>> callClone = call.clone();
		Response<List<Released>> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
}