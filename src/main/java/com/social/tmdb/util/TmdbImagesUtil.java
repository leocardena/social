package com.social.tmdb.util;

import java.util.List;
import com.social.tmdb.exception.TMDBBackdropImageNotContains;
import com.social.tmdb.exception.TMDBPosterImageNotContains;
import com.social.tmdb.model.Backdrop;
import com.social.tmdb.model.Images;
import com.social.tmdb.model.Poster;

public class TmdbImagesUtil {
	
	public static Backdrop getFirstBackDropFromImages(Images images) {
		List<Backdrop> list = images.getBackdrops();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new TMDBBackdropImageNotContains("A imagem do tipo backdrop não foi encontrada.");
		}
	} 
	
	public static Poster getFirstPosterFromImages(Images images) {
		List<Poster> list =images.getPosters();
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

}
