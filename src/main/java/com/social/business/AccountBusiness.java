package com.social.business;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;
import com.social.domain.User;
import com.social.web.rest.dto.UserDTO;

public interface AccountBusiness {
	
	@PreAuthorize("permitAll")
	public User createNewUser(UserDTO userDTO);
	
	@PreAuthorize("permitAll")
    public User activateRegistration(String key);
	
	@PreAuthorize("permitAll")
	public UserDTO getUserWithAuthorities();
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public String saveAvatar(Long code, MultipartFile avatar);

}
