package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Season;
import com.social.trakt.services.SeasonTraktAPIService;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class SeasonTraktAPIBusinessImpl implements SeasonTraktAPIBusiness {

	@Autowired
	SeasonTraktAPIService seasonAPIService;
	
	@Override
	public List<Season> getSummarySeason(String id, String extended) {
		Call<List<Season>> call = seasonAPIService.getSummarySeason(id, extended);
		Call<List<Season>> callClone = call.clone();
		Response<List<Season>> resp;
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
	public List<FirstAired> getAllSeasonPremieres(String start_date, int days, String extended, String query,
			String genres) {
		Call<List<FirstAired>> call = seasonAPIService.getAllSeasonPremieres(start_date, days, extended, query, genres);
		Call<List<FirstAired>> callClone = call.clone();
		Response<List<FirstAired>> resp;
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
