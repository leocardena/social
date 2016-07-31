package com.social.trakt.business;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import com.social.retrofit.RetrofitBuilder;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Movie;
import com.social.trakt.services.MovieAPIService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class MovieAPIBusiness {

	private MovieAPIService movieAPIService;

	public MovieAPIBusiness() {
		Retrofit retrofit = RetrofitBuilder.getInstance();
		this.movieAPIService = retrofit.create(MovieAPIService.class);
	}

	public Map<String, Object> getPopularMovies( String page, String limit, String extended ) {
		Call<List<Movie>> call = movieAPIService.getPopularMovies( page, limit, extended );
		Call<List<Movie>> callClone = call.clone();
		Response<List<Movie>> resp;
		try {
			resp = callClone.execute();
			if ( !resp.isSuccessful() ) 
				throw new RetrofitException("A resposta não foi bem sucedida");
			
			List<Movie> movies = resp.body();
			HttpHeaders headers = getHeadersList(resp);
			Map<String, Object> results = new HashMap<String, Object>();
			results.put("headers", headers);
			results.put("movies", movies);
			return results;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	
	public HttpHeaders getHeadersList(Response<List<Movie>> response) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("X-Pagination-Item-Count", response.headers().get("X-Pagination-Item-Count"));
		responseHeaders.add("X-Pagination-Limit", response.headers().get("X-Pagination-Limit"));
		responseHeaders.add("X-Pagination-Page", response.headers().get("X-Pagination-Page"));
		responseHeaders.add("X-Pagination-Page-Count", response.headers().get("X-Pagination-Page-Count"));	
		
		return responseHeaders; 
	}

}
