package com.social.trakt.business;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Episode;
import com.social.trakt.services.EpisodeAPIService;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class EpisodeAPIBusiness {

	@Autowired
	EpisodeAPIService episodeAPIService;

	public Episode getSummaryEpisode(String id, int season, int episode, String extended) {
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

	public List<Episode> getEpisodeForSeason(String id, int season, String extended) {
		Call<List<Episode>> call = episodeAPIService.getEpisodeForSeason(id, season, extended);
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
