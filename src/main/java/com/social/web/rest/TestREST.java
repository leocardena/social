package com.social.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.business.ListsBusiness;
import com.social.business.MovieBusiness;
import com.social.business.MovieBusinessImpl;
import com.social.domain.Movie;
import com.social.domain.Profile;

@RestController
public class TestREST {

	@Autowired
	private ListsBusiness listBusiness;
	@Autowired
	private MovieBusiness movieBusiness;
	
	@GetMapping(value="/get-lists")
	public String getAllLists(){
		Profile profile = new Profile();
		profile.setId((long) 2);
		listBusiness.getAllListByProfile(profile);
		System.out.println("TESTE AQUI");
		return "Pegou todas as listas";
	}
	
	@GetMapping(value="/get-movie")
	public Movie getMovieByName(){
		return movieBusiness.getMovieByName("Amazing Spider Man");
	}	
	
	public List<Movie> getAllMoviesByName(){
		return movieBusiness.getAllMoviesByName("ar");
	}	

	@GetMapping(value="/get-rating")
	public void avgRatingByRatinParent(){
		movieBusiness.getAvgRatingById(2L);
	}
}   

