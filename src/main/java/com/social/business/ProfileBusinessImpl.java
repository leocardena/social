package com.social.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.ProfileRepository;
import com.social.repository.RatingRepository;
import com.social.repository.UserRepository;
import com.social.util.Compatibility;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.dto.RatingDTO;

@Service
public class ProfileBusinessImpl implements ProfileBusiness {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private AccountBusiness accountBusiness;
	
	@Override
	public ProfileDTO getProfile(String username) {

		Optional<User> userOptional = userRepository.findOneByUsername(username);
		if(!userOptional.isPresent())
			throw new ResourceNotFoundException("Usuário não encontrado!");
		
		Profile profileFriend = profileRepository.findOneByUser(userOptional.get()).get();
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(profileFriend.getId());
		profileDTO.setName(profileFriend.getName());
		profileDTO.setGenre(profileFriend.getGenre());
		profileDTO.setAvatar(profileFriend.getAvatar());
		profileDTO.setCountry(profileFriend.getCountry());
		
		Profile profile = accountBusiness.findProfileByLoggedUser();
		Long value = ratingRepository.compatibilityBetweenFriends(profile.getId(), profileFriend.getId());
		profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));
		
		return profileDTO;
	}

}
