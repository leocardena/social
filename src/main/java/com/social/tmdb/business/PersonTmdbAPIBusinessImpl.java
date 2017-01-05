package com.social.tmdb.business;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.exception.TMDBImageNotFound;
import com.social.tmdb.model.Images;
import com.social.tmdb.model.Profile;
import com.social.tmdb.services.PersonTmdbAPIService;
import com.social.tmdb.util.ConfigurationTmdbAPIConnection;
import com.social.tmdb.util.TmdbImagesUtil;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class PersonTmdbAPIBusinessImpl implements PersonTmdbAPIBusiness {

	@Autowired
	private PersonTmdbAPIService personTmdbAPIService;
	
	@Autowired
	private ConfigurationTmdbAPIConnection config;
	
	@Override
	public Profile getPersonImages(String personId, String profileSize) {
		Call<Images> call = personTmdbAPIService.getPersonImages(personId);
		Call<Images> callClone = call.clone();
		Response<Images> resp;
		try {
			resp = callClone.execute();
			if (resp.code() == 404)
				throw new TMDBImageNotFound("A imagem não foi encontrada na API TMDB");
			if (!resp.isSuccessful())
				throw new RetrofitException("A resposta não foi bem sucedida");
			Images images = resp.body();
			Profile profile = TmdbImagesUtil.getFirstProfileFromImages(images);
			if (profile.getFilePath() != null ) profile.setFilePath(config.getImageURL(profileSize, profile.getFilePath()));
			return profile;
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}
	}

}
