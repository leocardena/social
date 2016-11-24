package com.social.tmdb.business;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.model.Show;
import com.social.tmdb.model.ShowPagination;
import com.social.tmdb.services.ShowTmdbAPIService;
import com.social.tmdb.util.ConfigurationTmdbAPIConnection;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class ShowTmdbAPIBusiness {

	@Autowired
	private ShowTmdbAPIService showTmdbAPIService;
	
	@Autowired
	private ConfigurationTmdbAPIConnection config;
	
	public Show getPopularRandomShow(String size) {
		Call<ShowPagination> call = showTmdbAPIService.getPopularShows();
		Call<ShowPagination> callClone = call.clone();
		Response<ShowPagination> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			ShowPagination showResponse = resp.body();
			List<Show> shows = showResponse.getShows();
			Random randomizer = new Random();
			Show show = shows.get(randomizer.nextInt(shows.size()));
			String backdropPath = config.getImageURL(size, show.getBackdropPath());
			show = new Show();
			show.setBackdropPath(backdropPath);
			return show;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
