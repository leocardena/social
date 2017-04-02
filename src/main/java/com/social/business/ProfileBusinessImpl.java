package com.social.business;

import java.util.ArrayList;
import java.util.List;
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
import com.social.repository.custom.interfaces.ProfileRepositoryCustom;
import com.social.util.Compatibility;
import com.social.web.rest.dto.ProfileDTO;

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
	
	private ProfileRepositoryCustom profileRepositoryCustom;
	
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
//		profileDTO.setAvatar(avatarStorage.getUrl(profileFriend.getAvatar()));
		profileDTO.setCountry(profileFriend.getCountry());
		
		Profile profile = accountBusiness.findProfileByLoggedUser();
		if(profile != null){
			Long value = ratingRepository.compatibilityBetweenFriends(profile.getId(), profileFriend.getId());
			profileDTO.setCompatibility(
						Compatibility.getCompatibility(Long.valueOf(value).intValue()));
		}
		
		return profileDTO;
	}

	@Override
	public Profile getProfile(Long idProfile) {

		Optional<Profile> profile = profileRepository.findOneById(idProfile);
		if(!profile.isPresent())
				throw new ResourceNotFoundException("Perfil não encontrado");
				
		return profile.get();
	}

	@Override
	public List<ProfileDTO> getLikeProfile(String username) {

		List<Profile> listProfile = profileRepositoryCustom.getProfileLikeUsername(username);
		if(listProfile == null)
			throw new ResourceNotFoundException("Nenhum Perfil encontrado");
		
		List<ProfileDTO> listProfileDTO = new ArrayList<>();
		listProfile.forEach((p)->{
			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setId(p.getId());
			profileDTO.setGenre(p.getGenre());
//			profile.setAvatar(avatarStorage.getUrl(p.getAvatar()));
			profileDTO.setName(p.getName());
			
			if(accountBusiness.findProfileByLoggedUser() != null){
				Long value = ratingRepository.compatibilityBetweenFriends(
						accountBusiness.findProfileByLoggedUser().getId(), p.getId());
				profileDTO.setCompatibility(
							Compatibility.getCompatibility(Long.valueOf(value).intValue()));
			}
			
			listProfileDTO.add(profileDTO);
			
		});
		
		return listProfileDTO;
	}

}
