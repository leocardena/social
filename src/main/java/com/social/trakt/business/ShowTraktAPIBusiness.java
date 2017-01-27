package com.social.trakt.business;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.social.domain.ResponseAPI;
import com.social.trakt.model.FirstAired;
import com.social.trakt.model.Show;

public interface ShowTraktAPIBusiness {
	
	/**
	 * Retorna as series populares
	 * 
	 * @param page
	 *    	  A pagina atual
	 *    
	 * @param limit
	 * 		  A quantidade de resultados por pagina
	 * 
	 * @param extended
	 *    	  O detalhamento das informacoes
	 *    
	 * @param query
	 *    	  O texto de pesquisa
	 *    
	 * @param genres
	 * 		  Os generos
	 * 
	 * @return As series populares
	 */
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Show>> getPopularShows(String page, String limit, String extended, String query,
			String genres);
	
	/**
	 * Retorna as infomacoes de uma serie
	 * 
	 * @param id	
	 * 		  O id da serie
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes
	 * 
	 * @return A serie pesquisada
	 */
	@PreAuthorize("permitAll")
	public Show getSummaryShow(String id, String extended);
	
	/**
	 * Retorna a traducao das informacoes da serie
	 * 
	 * @param id
	 * 		  O id da serie a ser traduzida
	 * 
	 * @param language
	 * 		  A lingua desejada para traducao
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes
	 * 
	 * @return As informacoes da serie traduzidas
	 */
	@PreAuthorize("permitAll")
	public List<Show> getShowTranslation(String id, String language, String extended);
	
	/**
	 * Retorna as series relacionadas em relacao a serie pesquisada
	 * 
	 * @param id
	 * 		  O id da serie
	 * 
	 * @param page
	 * 		  A pagina atual
	 * 
	 * @param limit
	 * 		  A quantidade de resultados por pagina
	 * 
	 * @param extended
	 * 		  O detalhamento das informacoes retornadas
	 * 
	 * @return As series relacionadas
	 */
	@PreAuthorize("permitAll")
	public ResponseAPI<List<Show>> getRelatedShows(String id, String page, String limit, String extended);
	
	/**
	 * Retorna todos os show de acordo com os filtros de pesquisa requisitados
	 * 
	 * @param start_date
	 *        a data de inicio
	 *        
	 * @param days
	 *        a quantidade de dias
	 *        
	 * @param extended
	 * 		  o detalhamento das informacoes retornadas
	 * 
	 * @param query
	 *        o texto de pesquisa
	 *        
	 * @param genres
	 *        os gerenos
	 *        
	 * @return As series de acordo com a pesquisa requisitada
	 */
	@PreAuthorize("permitAll")
	public List<FirstAired> getAllShows(String start_date, int days, String extended, String query, String genres);
	
	/**
	 * Retorna as novas series lancadas
	 * 
	 * @param start_date
	 *        a data de inicio
	 *        
	 * @param days
	 *        a quantidade de dias
	 *        
	 * @param extended
	 * 		  o detalhamento das informacoes retornadas
	 * 
	 * @param query
	 *        o texto de pesquisa
	 *        
	 * @param genres
	 *        os gerenos
	 *        
	 * @return As novas series de acordo com a pesquisa requisitada
	 */
	@PreAuthorize("permitAll")
	public List<FirstAired> getNewAllShows(String start_date, int days, String extended, String query, String genres);
	
}
