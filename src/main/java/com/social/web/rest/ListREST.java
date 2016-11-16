package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.business.ListsBusiness;
import com.social.business.TitleBusiness;
import com.social.domain.Lists;

@RestController
public class ListREST {

	@Autowired
	private ListsBusiness listBusiness;
	@Autowired
	private TitleBusiness titleBusiness;
	
	@GetMapping(value="/get-lists/{pageSize}/{pageCurrent}")
	public Page<Lists> getAllLists(@PathVariable("pageSize") Integer pageSize, 
			@PathVariable("pageCurrent") Integer pageCurrent){
		return listBusiness.getAllLists(pageCurrent, pageSize);
	}
	
	@GetMapping(value="/test-insert")
	public String insertTest(){
		titleBusiness.getTitleById(3L);
		return "Salvo com sucesso";
	}
	
}
