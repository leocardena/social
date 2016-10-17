package com.social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.social.domain.Lists;
import com.social.rest.business.ListsBusiness;

@RestController
public class ListREST {

	@Autowired
	private ListsBusiness listBusiness;
	
	@GetMapping(value="/get-lists/{pageSize}/{pageCurrent}")
	public Page<Lists> getAllLists(@PathVariable("pageSize") Integer pageSize, 
			@PathVariable("pageCurrent") Integer pageCurrent){
		return listBusiness.getAllLists(pageCurrent, pageSize);
	}
	
}
