package com.social.trakt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.trakt.business.MovieTraktAPIBusiness;
import com.social.trakt.business.PersonTraktAPIBusiness;
import com.social.trakt.model.Movie;
import com.social.trakt.util.APITraktEndpoint;
import com.social.web.rest.response.ResponseAPI;

@RestController
@RequestMapping(value = APITraktEndpoint.MOVIE)
public class MovieTraktREST {

	@Autowired
	private MovieTraktAPIBusiness business;
	
	@Autowired
	private PersonTraktAPIBusiness personBusiness;

	/**
	 * Returna os filmes populares do trakttv baseados na quantidade de rating e
	 * suas notas mais altas
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
			@PathVariable("language") String language) {
		return ResponseEntity.ok(business.getMovieTranslation(movieId, language));
	}
	
	/**
	 * Retorna as pessoas envolvidas em um filme
	 * 
	 * @param movieId o id do filme
	 * @param extented detalhamento das informacoes retornadas
	 * @return as pessoas envolvidas no filme
	 */
	@GetMapping(value = "/{movieId}/peoples")
	public ResponseEntity<?> getAllPeopleForAMovie(@PathVariable("movieId") String movieId,
			@RequestParam(value = "extended", required = false) String extented) {
		return ResponseEntity.ok(personBusiness.getAllPeopleForAMovie(movieId, extented));
	}
	
	/**
	 * Retorna as informacoes de um único filme em especifico
	 * 
	 * @param movieId o id do filme
	 * @param extented o detalhamento das informacoes retornadas
	 * @return as informacoes do filme requisitado
	 */
	@GetMapping(value = "/{movieId}")
	public ResponseEntity<?> getSummaryMovie(@PathVariable("movieId") String movieId,
			@RequestParam(value = "extended", required = false) String extented) {
		return ResponseEntity.ok(business.getSummaryMovie(movieId, extented));
	}
	
	/**
	 * Returna os filmes relacionados a um filme em especifico
	 * 
	 * @param page a pagina atual
	 * @param limit a quantidade de resultados por pagina
	 * @param extended o detalhamento das informacoes
	 * @return os movies relacionados
	 */
	@GetMapping(value = "/{movieId}/related")
	public ResponseEntity<?> getRelatedMovies(@PathVariable("movieId") String movieId,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String limit,
			@RequestParam(value = "extended", required = false) String extended) {

		ResponseAPI<List<Movie>> response = business.getRelatedMovies(movieId, page, limit, extended);
		return ResponseEntity.ok().headers(response.getHeaders()).body(response.getBody());
	}
	
}