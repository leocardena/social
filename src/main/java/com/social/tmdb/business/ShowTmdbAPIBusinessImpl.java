package com.social.tmdb.business;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.business.interfaces.ShowTmdbAPIBusiness;
import com.social.tmdb.exception.TMDBImageNotFound;
import com.social.tmdb.model.Backdrop;
import com.social.tmdb.model.Images;
import com.social.tmdb.model.Poster;
import com.social.tmdb.model.Show;
import com.social.tmdb.model.ShowPagination;
import com.social.tmdb.model.Still;
import com.social.tmdb.services.ShowTmdbAPIService;
import com.social.tmdb.util.ConfigurationTmdbAPIConnection;
import com.social.tmdb.util.TmdbImagesUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class ShowTmdbAPIBusinessImpl implements ShowTmdbAPIBusiness {

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
	
	public Map<String, Object> getShowImages(String showId, String backdropSize, String posterSize, String language) {
		Call<Images> call = showTmdbAPIService.getShowImages(showId, language, "pt,en,null");
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
			if (poster.getHeight() != null) poster.setFilePath(config.getImageURL(posterSize, poster.getFilePath()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("backdrop", backdrop);
			map.put("poster", poster);
			return map;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	public Poster getSeasonImages(String showId, String posterSize, String language, String seasonNumber) {
		Call<Images> call = showTmdbAPIService.getSeasonImages(showId, seasonNumber, language, "pt,en,null");
		Call<Images> callClone = call.clone();
		Response<Images> resp;
		try {
			resp = callClone.execute();
			if (resp.code() == 404)
				throw new TMDBImageNotFound("A imagem não foi encontrada na API TMDB");
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			Images images = resp.body();
			Poster poster = TmdbImagesUtil.getFirstPosterFromImages(images);
			if (poster.getFilePath() != null) poster.setFilePath(config.getImageURL(posterSize, poster.getFilePath()));
			return poster;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}
	
	public Still getEpisodeImages(String showId, String stillSize, String episodeNumber, String seasonNumber) {
		Call<Images> call = showTmdbAPIService.getEpisodeImages(showId, episodeNumber, seasonNumber);
		Call<Images> callClone = call.clone();
		Response<Images> resp;
		try {
			resp = callClone.execute();
			if (resp.code() == 404)
				throw new TMDBImageNotFound("A imagem não foi encontrada na API TMDB");
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			Images images = resp.body();
			Still still = TmdbImagesUtil.getFirstStillFromImages(images);
			if (still.getFilePath() != null) still.setFilePath(config.getImageURL(stillSize, still.getFilePath()));
			return still;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
