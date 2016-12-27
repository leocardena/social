package com.social.trakt.business;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.trakt.model.Genre;
import com.social.trakt.services.GenreTraktAPIService;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class GenreTraktAPIBusinessImpl implements GenreTraktAPIBusiness {

	@Autowired
	GenreTraktAPIService genreAPIService;
	
	@Override
	public List<Genre> getListGenres(String type) {
		Call<List<Genre>> call = genreAPIService.getListGenres(type);
		Call<List<Genre>> callClone = call.clone();
		Response<List<Genre>> resp;
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
