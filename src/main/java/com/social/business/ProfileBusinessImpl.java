package com.social.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Friend;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.FriendRepository;
import com.social.repository.ProfileRepository;
import com.social.repository.RatingRepository;
import com.social.repository.UserRepository;
import com.social.security.util.SecurityUtils;
import com.social.storage.AvatarStorage;
import com.social.util.Compatibility;
import com.social.util.FriendStatus;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.dto.RatingTargetDTO;
import com.social.web.rest.exception.ResourceNotFoundException;
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
	
	@Autowired
	private FriendRepository friendRepository;

	@Override
	public ProfileDTO getProfile(String username) {

		Optional<User> userOptional = userRepository.findOneByUsername(username);
		if (!userOptional.isPresent())
			throw new ResourceNotFoundException("Usuário não encontrado!");

		Profile profileFriend = profileRepository.findOneByUser(userOptional.get()).get();
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		ProfileDTO profileDTO = new ProfileDTO();
		profileDTO.setId(profileFriend.getId());
		profileDTO.setName(profileFriend.getName());
		profileDTO.setGenre(profileFriend.getGenre());
		profileDTO.setCountry(profileFriend.getCountry());
		profileDTO.setUsername(profileFriend.getUser().getUsername());
		profileDTO.setBirthday(dtf.print(profileFriend.getBirthday()));
		profileDTO.setCreatedDate(dtf.print(profileFriend.getUser().getCreatedDate()));

		if (profileFriend.getAvatar() != null) {
			profileDTO.setAvatar(avatarStorage.getUrl(profileFriend.getAvatar()));
		}
		
		String loggedUsername = SecurityUtils.getCurrentUserLogin();
		if (loggedUsername != null) {
			Profile profile = accountBusiness.findProfileByLoggedUser().get();
			Long value = ratingRepository.compatibilityBetweenFriends(profile.getId(), profileFriend.getId());
			profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));
			
			Optional<Friend> friendOptional = friendRepository.findFriendsById(profile.getId(), profileFriend.getId());
			
			if (friendOptional.isPresent()) {
				Friend friendShip = friendOptional.get();
				if (friendShip.getStatus() == FriendStatus.WAITING) {
					if (friendShip.getId().getFriend() == profile.getId()) {
						profileDTO.setFriendStatus("Pending");
					} else {
						profileDTO.setFriendStatus(friendShip.getStatus().toString());
					}
				} else {
					profileDTO.setFriendStatus(friendShip.getStatus().toString());
				}
			} else {
				profileDTO.setFriendStatus(FriendStatus.NONE.toString());
			}
			
		}
		
		List<RatingTargetDTO<?>> ratings = ratingRepository.findRatingsByIdProfile(profileFriend.getId());
		profileDTO.setRatings(ratings);

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

			if (p.getAvatar() != null) {
				profileDTO.setAvatar(avatarStorage.getUrl(p.getAvatar()));
			}
			
			if (accountBusiness.findProfileByLoggedUser() != null) {
				Long value = ratingRepository
						.compatibilityBetweenFriends(accountBusiness.findProfileByLoggedUser().get().getId(), p.getId());
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
