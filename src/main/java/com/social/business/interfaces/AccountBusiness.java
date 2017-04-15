package com.social.business.interfaces;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import com.social.domain.Profile;
import com.social.domain.User;
import com.social.web.rest.dto.UserDTO;
import com.social.web.rest.vm.AccountVM;
import com.social.web.rest.vm.PasswordVM;

public interface AccountBusiness {
	
	@PreAuthorize("permitAll")
	public User createNewUser(UserDTO userDTO);
	
	@PreAuthorize("permitAll")
    public User activateRegistration(String key);
	
	@PreAuthorize("permitAll")
	public UserDTO getUserWithAuthorities();
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public String saveAvatar(MultipartFile avatar);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public void deleteAvatar();
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public UserDTO putAccount(AccountVM accountVM, Long userId);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public void putPassoword(PasswordVM passwordVM, Long userId);
	
	Optional<Profile> findProfileByLoggedUser();

}