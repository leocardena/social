package com.social.trakt.services;

import java.util.List;
import com.social.trakt.model.Search;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Interface utilizada para realizar requisições ao recurso Search do Trakt.tv
 * 
 * @author Leonardo Cardena
 *
 */
public interface SearchTraktAPIService {

	/**
	 * @param type
	 *            tipo da pesquisa. Ex.: movie, show..
	 * @param page
	 *            o número da página que virá na resposta
	 * @param limit
	 *            quantidade de resultados retornados na resposta
	 * @param extended
	 *            tipo de detalhamento da informação que será enviada na
	 *            resposta
	 * @param query
	 *            o texto a ser pesquisado
	 * @param fields
	 *            os campos no qual o texto será pesquisado
	 * @return a resposta da requisição
	 */
	@GET("/search/{type}")
	public Call<List<Search>> getSearch(@Path("type") String type, @Query("page") String page,
			@Query("limit") String limit, @Query("extended") String extended, @Query("query") String query,
			@Query("fields") String fields);

}
