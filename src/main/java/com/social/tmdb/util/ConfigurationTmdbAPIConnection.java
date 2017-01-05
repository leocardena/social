package com.social.tmdb.util;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.social.retrofit.exception.RetrofitException;
import com.social.tmdb.exception.TMDBImageSizeNotContains;
import com.social.tmdb.model.ImagesSize;
import com.social.tmdb.model.TmdbConfiguration;
import com.social.tmdb.services.ConfigurationTmdbAPIService;
import com.social.util.ContainsEnum;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Classe reponsável por obter a configuração das imagens e montar suas URLs 
 * @author Cardena
 *
 */
@Service
public class ConfigurationTmdbAPIConnection {

	private ConfigurationTmdbAPIService tmdbConfigurationService;
	private TmdbConfiguration tmdbConfiguration;

	@Autowired
	public ConfigurationTmdbAPIConnection(ConfigurationTmdbAPIService tmdbConfigurationService) {
		super();
		this.tmdbConfigurationService = tmdbConfigurationService;
		this.tmdbConfiguration = this.getConfigurationTmdb();
	}
	
	/**
	 * @return as informações de configuração para a requisição das imagens
	 */
	private TmdbConfiguration getConfigurationTmdb() {
		Call<TmdbConfiguration> call = tmdbConfigurationService.getTmdbConfiguration();
		Call<TmdbConfiguration> callClone = call.clone();
		Response<TmdbConfiguration> resp;
		try {
			resp = callClone.execute();
			if (!resp.isSuccessful()) {
				ImagesSize images = new ImagesSize();
				images.setSecureBaseUrl("https://image.tmdb.org/t/p/");
				TmdbConfiguration config = new TmdbConfiguration();
				config.setImages(images);
				return config;
			}
				
			return resp.body();
		} catch (IOException e) {
			throw new RetrofitException("Erro ao executar request através da API");
		}

	}
	
	/**
	 * @param size tamanho da imagem a ser requisitada
	 * @param path o path da imagem de será montada a URL
	 * @return a URL da imagem montada
	 */
	public String getImageURL(String size, String path) {
		size = size.toUpperCase();
		if (ContainsEnum.contains(StillSizes.class, size) || ContainsEnum.contains(LogoSizes.class, size)
				|| ContainsEnum.contains(PosterSizes.class, size) || ContainsEnum.contains(BackdropSizes.class, size)
				|| ContainsEnum.contains(ProfileSizes.class, size)) {
			StringBuilder sb = new StringBuilder();
			sb.append(this.tmdbConfiguration.getImages().getSecureBaseUrl());
			sb.append(size.toLowerCase());
			sb.append(path);
			return sb.toString();
		} else {
			throw new TMDBImageSizeNotContains("O Tamanho informado '" + size.toLowerCase() + "' de imagem para o TMDB é inválida");
		}
	}

}
