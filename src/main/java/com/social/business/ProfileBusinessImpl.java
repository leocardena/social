package com.social.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.ProfileRepository;
import com.social.repository.UserRepository;
import com.social.web.rest.dto.ProfileDTO;

@Service
public class ProfileBusinessImpl implements ProfileBusiness {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ProfileDTO getProfile(String username) {

		Optional<User> userOptional = userRepository.findOneByUsername(username);
		if(!userOptional.isPresent())
			throw new ResourceNotFoundException("Usuário não encontrado!");
		
		Profile profile = profileRepository.findOneByUser(userOptional.get()).get();
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(profile.getId());
		profileDTO.setName(profile.getName());
		profileDTO.setGenre(profile.getGenre());
		profileDTO.setAvatar(profile.getAvatar());
		profileDTO.setCountry(profile.getCountry());
		
		return profileDTO;
	}

}
