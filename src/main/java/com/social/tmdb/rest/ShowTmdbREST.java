package com.social.tmdb.rest;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.social.tmdb.business.ShowTmdbAPIBusiness;
import com.social.tmdb.model.Poster;
import com.social.tmdb.model.Show;
import com.social.tmdb.model.Still;
import com.social.tmdb.util.ApiTmdbEndpoint;

@RestController
@RequestMapping(value = ApiTmdbEndpoint.SHOW)
public class ShowTmdbREST {

	@Autowired
	private ShowTmdbAPIBusiness business;

	@GetMapping(value = "/popular/random")
	public ResponseEntity<?> getPopularMovies(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "size", required = true) String size) {
		Show show = business.getPopularRandomShow(size);
		return ResponseEntity.ok().body(show);
	}

	@GetMapping(value = "/{showId}/images")
	public ResponseEntity<?> getShowImages(@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "posterSize", required = true) String posterSize,
			@RequestParam(value = "backdropSize", required = true) String backdropSize,
			@PathVariable(value = "showId") String showId) {
		Map<String, Object> map = business.getShowImages(showId, backdropSize, posterSize, language);
		return ResponseEntity.ok().body(map);
	}

	@GetMapping(value = "/{showId}/season/{seasonNumber}/images")
	public ResponseEntity<?> getSeasonImages(@RequestParam(value = "language", required = false) String language,
			@RequestParam(value = "posterSize", required = true) String posterSize,
			@PathVariable(value = "showId") String showId, @PathVariable(value = "seasonNumber") String seasonNumber) {
		Poster poster = business.getSeasonImages(showId, posterSize, language, seasonNumber);
		return ResponseEntity.ok().body(poster);
	}

	@GetMapping(value = "/{showId}/season/{seasonNumber}/episode/{episodeNumber}/images")
	public ResponseEntity<?> getEpidodeImages(@RequestParam(value = "stillSize", required = true) String stillSize,
			@PathVariable(value = "episodeNumber") String episodeNumber, @PathVariable(value = "showId") String showId,
			@PathVariable(value = "seasonNumber") String seasonNumber) {
		Still still = business.getEpisodeImages(showId, stillSize, episodeNumber, seasonNumber);
		return ResponseEntity.ok().body(still);
	}

}
