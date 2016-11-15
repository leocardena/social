package com.social.tmdb.util;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.model.TmdbConfiguration;
import com.social.tmdb.services.ConfigurationTmdbAPIService;
import retrofit2.Call;
import retrofit2.Response;

public class ConfigurationTmdbAPI {
	
	@Autowired
	private static ConfigurationTmdbAPIService tmdbConfigurationService;
	
	private final static TmdbConfiguration TMDB_CONFIGURATION  = ConfigurationTmdbAPI.getConfigurationTmdb();
	
	private ConfigurationTmdbAPI() {
	}
	 
	private static TmdbConfiguration getConfigurationTmdb() {
		Call<TmdbConfiguration> call = tmdbConfigurationService.getTmdbConfiguration();
		Call<TmdbConfiguration> callClone = call.clone();
		Response<TmdbConfiguration> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
		
	}
	
	public TmdbConfiguration getInstance() {
		return TMDB_CONFIGURATION;
	}

}
