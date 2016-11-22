package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.business.ListsBusiness;
import com.social.business.TvShowBusiness;
import com.social.domain.Lists;
import com.social.domain.Profile;

@RestController
public class ListREST {

	@Autowired
	private ListsBusiness listBusiness;
	@Autowired
	private TvShowBusiness tvShowBusiness;
	
	@GetMapping(value="/get-lists")
	public String getAllLists(){
		Profile profile = new Profile();
		profile.setId((long) 2);
		listBusiness.getAllListByProfile(profile);
		return "Pegou todas as listas";
	}
	
	@GetMapping(value="/test-insert/tvshow")
	public String insertTestTvShow(){
		tvShowBusiness.getAllTvShowById("White Collar");
		return "Buscou com sucesso";
	}
	
}
