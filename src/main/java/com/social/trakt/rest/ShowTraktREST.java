package com.social.trakt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.domain.ResponseAPI;
import com.social.trakt.business.ShowTraktAPIBusiness;
import com.social.trakt.model.Show;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.SHOW)
public class ShowTraktREST {

	@Autowired
	private ShowTraktAPIBusiness business;

	/**
	 * Returna os shows populares do trakttv baseados na quantidade de rating e
	 * suas notas mais altas
	 * 
	 * @param page
	 *            a pagina atual
	 * @param limit
	 *            a quantidade de resultados por pagina
	 * @param extended
	 *            o detalhamento das informacoes
	 * @param query
	 *            texto de pesquisa para filtrar os resultados
	 * @param genres
	 *            filtra shows populares por genero
	 * @return os shows populares
	 */
	@GetMapping(value = "/popular")
	public ResponseEntity<?> getPopularShows(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "genres", required = false) String genres) {

		ResponseAPI<List<Show>> response = business.getPopularShows(page, limit, extended, query, genres);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
	}

	/**
	 * Retorna a traducao de um show
	 * 
	 * @param id
	 *            o id do show
	 * @param language
	 *            a lingua na qual o show sera traduzido
	 * @param extended
	 *            detalhamento das informacoes retornadas
	 * @return o show traduzido
	 */
	@GetMapping(value = "/{showId}/translations/{language}")
	public ResponseEntity<?> getShowTranslation(@PathVariable("showId") String showId,
			@PathVariable("language") String language,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(business.getShowTranslation(showId, language, extended));
	}

}
