package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.social.domain.ResponseAPI;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Movie;
import com.social.trakt.services.MovieAPIService;
import com.social.util.PaginationUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class MovieAPIBusiness {

	@Autowired
	private MovieAPIService movieAPIService;

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

	public ResponseAPI<Movie> getSummaryMovies(String id, String extended){
		Call<Movie> call = movieAPIService.getSummaryMovies(id, extended);
		Call<Movie> callClone = call.clone();
		Response<Movie> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			Movie movies = resp.body();
			ResponseAPI<Movie> responseAPI = new ResponseAPI<>();
			responseAPI.setBody(movies);
			return responseAPI;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
			
		
	}
}
