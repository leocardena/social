package com.social.tmdb.util;

import java.util.List;
import com.social.tmdb.exception.TMDBBackdropImageNotContains;
import com.social.tmdb.exception.TMDBPosterImageNotContains;
import com.social.tmdb.exception.TMDBProfileImageNotContains;
import com.social.tmdb.exception.TMDBStillImageNotContains;
import com.social.tmdb.model.Backdrop;
import com.social.tmdb.model.Images;
import com.social.tmdb.model.Poster;
import com.social.tmdb.model.Profile;
import com.social.tmdb.model.Still;

/**
 * Classe utilitária responsável por conferir a disponibilidade das imagens
 * contidas na response do tmdb e selecioná-las para ser enviada na response da
 * aplicação
 * 
 * @author Leonardo Cardena
 *
 */
public class TmdbImagesUtil {
	
	/**
	 * @param images objeto que representa a imagem contida na response do tmdb
	 * @return imagem do tipo Backdrop
	 */
	public static Backdrop getFirstBackDropFromImages(Images images) {
		List<Backdrop> list = images.getBackdrops();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new TMDBBackdropImageNotContains("A imagem do tipo backdrop não foi encontrada.");
		}
	}

	/**
	 * @param images objeto que representa a imagem contida na response do tmdb
	 * @return imagem do tipo Poster
	 */
	public static Poster getFirstPosterFromImages(Images images) {
		List<Poster> list = images.getPosters();
		if (list.size() > 0) {
			for (Poster poster : list) {
				if (poster.getIso6391().equals("pt")) {
					return poster;
				}
			}
			return list.get(0);
		} else {
			throw new TMDBPosterImageNotContains("A imagem do tipo poster não foi encontrada.");
		}
	}
	
	/**
	 * @param images objeto que representa a imagem contida na response do tmdb
	 * @return imagem do tipo Profile
	 */
	public static Profile getFirstProfileFromImages(Images images) {
		List<Profile> list = images.getProfiles();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new TMDBProfileImageNotContains("A imagem do tipo profile não foi encontrada.");
		}
	}
	
	/**
	 * @param images objeto que representa a imagem contida na response do tmdb
	 * @return imagem do tipo Still
	 */
	public static Still getFirstStillFromImages(Images images) {
		List<Still> list = images.getStills();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new TMDBStillImageNotContains("A imagem do tipo profile não foi encontrada.");
		}
	}

}
