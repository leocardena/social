package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Episode;
import com.social.trakt.services.EpisodeTraktAPIService;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class EpisodeTraktAPIBusinessImpl implements EpisodeTraktAPIBusiness {

	@Autowired
	EpisodeTraktAPIService episodeAPIService;

	@Override
	public Episode getSummaryEpisode(String id, String season, String episode, String extended) {
		Call<Episode> call = episodeAPIService.getSummaryEpisode(id, season, episode, extended);
		Call<Episode> callClone = call.clone();
		Response<Episode> resp;
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
	public List<Episode> getTranslationsForAEpisode(String showId, String seasonNumber, String episodeNumber,
			String language) {
		Call<List<Episode>> call = episodeAPIService.getTranslationsForAEpisode(showId, seasonNumber, episodeNumber,
				language);
		Call<List<Episode>> callClone = call.clone();
		Response<List<Episode>> resp;
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