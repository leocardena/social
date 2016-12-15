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
import com.social.trakt.business.MovieTraktAPIBusiness;
import com.social.trakt.model.Movie;
import com.social.trakt.util.APITraktEndpoint;

@RestController
@RequestMapping(value = APITraktEndpoint.MOVIE)
public class MovieTraktREST {

	@Autowired
	private MovieTraktAPIBusiness business;
	
	/**
	 * Returna os shows populares do trakttv baseados 
	 * na quantidade de rating e suas notas mais altas
	 * 
	 * @param page a pagina atual
	 * @param limit a quantidade de resultados por pagina
	 * @param extended o detalhamento das informacoes
	 * @param query texto de pesquisa para filtrar os resultados
	 * @param genres filtra movies populares por genero
	 * @return os movies populares
	 */
	@GetMapping(value = "/popular")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended,
			@RequestParam(value = "query", required = false) String query,
			@RequestParam(value = "genres", required = false) String genres) {

		ResponseAPI<List<Movie>> response = business.getPopularMovies(page, limit, extended, query, genres);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
	}
	
	/**
	 * Retorna a traducao de um movie
	 * 
	 * @param id o id do movie
	 * @param language a lingua na qual o movie sera traduzido
	 * @param extended detalhamento das informacoes retornadas
	 * @return o movie traduzido
	 */
	@GetMapping(value = "/{movieId}/translations/{language}")
	public ResponseEntity<?> getMovieTranslation(@PathVariable("movieId") String movieId,
			@PathVariable("language") String language,
			@RequestParam(value = "extended", required = false) String extended) {
		return ResponseEntity.ok(business.getMovieTranslation(movieId, language, extended));
	}

}
