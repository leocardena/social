package com.social.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.ProfileRepository;
import com.social.repository.RatingRepository;
import com.social.repository.UserRepository;
import com.social.security.util.SecurityUtils;
import com.social.storage.AvatarStorage;
import com.social.util.Compatibility;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.response.PageableResponse;

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

	@Autowired
	private AvatarStorage avatarStorage;

	@Override
	public ProfileDTO getProfile(String username) {

		Optional<User> userOptional = userRepository.findOneByUsername(username);
		if (!userOptional.isPresent())
			throw new ResourceNotFoundException("Usuário não encontrado!");

		Profile profileFriend = profileRepository.findOneByUser(userOptional.get()).get();
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(profileFriend.getId());
		profileDTO.setName(profileFriend.getName());
		profileDTO.setGenre(profileFriend.getGenre());
		profileDTO.setCountry(profileFriend.getCountry());

		if (profileFriend.getAvatar() != null) {
			profileDTO.setAvatar(avatarStorage.getUrl(profileFriend.getAvatar()));
		}

		if (SecurityUtils.getCurrentUserLogin() != null) {
			Profile profile = accountBusiness.findProfileByLoggedUser();
			Long value = ratingRepository.compatibilityBetweenFriends(profile.getId(), profileFriend.getId());
			profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));
		}

		return profileDTO;
	}

	@Override
	public Profile getProfile(Long idProfile) {

		Optional<Profile> profile = profileRepository.findOneById(idProfile);
		if (!profile.isPresent())
			throw new ResourceNotFoundException("Perfil não encontrado");

		return profile.get();
	}

	@Override
	public PageableResponse<ProfileDTO> getLikeProfile(String username, Pageable pageable) {

		Page<Profile> pageProfile = profileRepository.getProfileLikeUsername(username, pageable);
		List<Profile> listProfile = pageProfile.getContent();
		List<ProfileDTO> listProfileDTO = new ArrayList<>();

		listProfile.forEach((p) -> {
			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setId(p.getId());
			profileDTO.setGenre(p.getGenre());
			profileDTO.setName(p.getName());
			profileDTO.setUsername(p.getUser().getUsername());
			profileDTO.setCountry(p.getCountry());

			if (profileDTO.getAvatar() != null) {
				profileDTO.setAvatar(avatarStorage.getUrl(profileDTO.getAvatar()));
			}

			if (accountBusiness.findProfileByLoggedUser() != null) {
				Long value = ratingRepository
						.compatibilityBetweenFriends(accountBusiness.findProfileByLoggedUser().getId(), p.getId());
				profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));
			}

			listProfileDTO.add(profileDTO);

		});

		PageableResponse<ProfileDTO> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(listProfileDTO);
		pageableResponse.setTotalPages(pageProfile.getTotalPages());
		pageableResponse.setNumber(pageProfile.getNumber());
		pageableResponse.setTotalElements(pageProfile.getTotalElements());
		pageableResponse.setSize(pageProfile.getSize());

		return pageableResponse;
	}

}
