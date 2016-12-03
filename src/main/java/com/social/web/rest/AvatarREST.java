package com.social.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.social.business.AccountBusiness;
import com.social.web.rest.util.APIEndpoint;

/**
 * Camada REST responsável por expor os serviços do recurso Avatar
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(APIEndpoint.AVATAR)
public class AvatarREST {

	@Autowired
	private AccountBusiness accountBusiness;
	
	/**
	 * @param codigo código do avatar
	 * @param files o arquivo
	 * @return o caminho onde o avatar foi salvo
	 */
	@RequestMapping(value = "/{code}", method = RequestMethod.POST)
	public String upload(@PathVariable Long codigo, @RequestParam("files[]") MultipartFile[] files) {
		return accountBusiness.saveAvatar(codigo, files[0]);
	}

}
