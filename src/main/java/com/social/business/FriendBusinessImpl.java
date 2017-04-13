package com.social.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.FriendBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Friend;
import com.social.domain.FriendPK;
import com.social.domain.Profile;
import com.social.repository.FriendRepository;
import com.social.repository.RatingRepository;
import com.social.storage.AvatarStorage;
import com.social.util.Compatibility;
import com.social.util.FriendStatus;
import com.social.web.rest.dto.FriendDTO;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.exception.FriendStatusBadGatewayException;
import com.social.web.rest.exception.ResourceNotFoundException;
import com.social.web.rest.response.PageableResponse;
import com.social.web.rest.vm.FriendStatusVM;
import com.social.web.rest.vm.FriendVM;

@Service
public class FriendBusinessImpl implements FriendBusiness {

	@Autowired
	private FriendRepository friendRepository;

	@Autowired
	private AccountBusiness accountBussiness;

	@Autowired
	private ProfileBusiness profileBusiness;

	@Autowired
	private AvatarStorage avatarStorage;

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public FriendDTO postFriend(FriendVM friendVM) {

		Profile friendProfile = profileBusiness.getProfile(friendVM.getIdFriend());

		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();

		FriendPK friendPK = new FriendPK(profileLogado.getId(), friendProfile.getId());
		Friend friend = new Friend();
		friend.setId(friendPK);
		friend.setStatus(FriendStatus.WAITING);
		Friend friendPersistido = friendRepository.save(friend);

		return FriendDTO.build(friendPersistido);

	}

	@Override
	public FriendDTO getFriend(Long idFriend) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();

		Optional<Friend> friendOptinal = friendRepository.findFriendsById(profileLogado.getId(), idFriend);

		if (!friendOptinal.isPresent())
			throw new ResourceNotFoundException("Amigo não encontrado");

		return FriendDTO.build(friendOptinal.get());
	}

	@Override
	public void deleteFriend(Long idFriend) {

		Profile friendSearch = profileBusiness.getProfile(idFriend);
		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();
		FriendPK friendPK = new FriendPK(profileLogado.getId(), friendSearch.getId());

		friendRepository.delete(friendPK);

	}

	@Override
	public FriendDTO patchFriend(FriendStatusVM status, Long idFriend) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();

		Optional<Friend> friendOptinal = friendRepository.findFriendsById(profileLogado.getId(), idFriend);

		if (!friendOptinal.isPresent())
			throw new ResourceNotFoundException("Amigo não encontrado");

		Friend friends = friendOptinal.get();
		FriendPK friendPK = new FriendPK(friends.getId().getProfile(), friends.getId().getFriend());
		Friend friend = new Friend();
		friend.setId(friendPK);
		friend.setStatus(status.getStatus());
		Friend updatedFriend = friendRepository.save(friend);

		return FriendDTO.build(updatedFriend);
	}

	@Override
	public PageableResponse<ProfileDTO> getFriends(Pageable pageable, String status) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();

		if (status.equalsIgnoreCase(FriendStatus.ACCEPT.toString())) {
			return this.getMyFriends(pageable, profileLogado);
		} else if (status.equalsIgnoreCase(FriendStatus.WAITING.toString())) {
			return this.getWaitingFriends(pageable, profileLogado);
		} else {
			throw new FriendStatusBadGatewayException("StatusFriend incorreto");
		}

	}

	private PageableResponse<ProfileDTO> getMyFriends(Pageable pageable, Profile profileLogado) {
		Page<Friend> friendsPageable = friendRepository.findAllFriends(FriendStatus.ACCEPT, profileLogado.getId(),
				pageable);
		List<ProfileDTO> listFriendsDTO = new ArrayList<>();

		friendsPageable.getContent().forEach(f -> {
			Profile friendProfile;

			if (f.getId().getFriend() != profileLogado.getId()) {
				friendProfile = profileBusiness.getProfile(f.getId().getFriend());
			} else {
				friendProfile = profileBusiness.getProfile(f.getId().getProfile());
			}

			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setId(friendProfile.getId());
			profileDTO.setGenre(friendProfile.getGenre());
			profileDTO.setName(friendProfile.getName());
			profileDTO.setUsername(friendProfile.getUser().getUsername());
			profileDTO.setCountry(friendProfile.getCountry());

			if (profileDTO.getAvatar() != null) {
				profileDTO.setAvatar(avatarStorage.getUrl(profileDTO.getAvatar()));
			}

			Long value = ratingRepository.compatibilityBetweenFriends(profileLogado.getId(), friendProfile.getId());
			profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));

			listFriendsDTO.add(profileDTO);

		});

		PageableResponse<ProfileDTO> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(listFriendsDTO);
		pageableResponse.setTotalPages(friendsPageable.getTotalPages());
		pageableResponse.setNumber(friendsPageable.getNumber());
		pageableResponse.setTotalElements(friendsPageable.getTotalElements());
		pageableResponse.setSize(friendsPageable.getSize());

		return pageableResponse;

	}

	private PageableResponse<ProfileDTO> getWaitingFriends(Pageable pageable, Profile profileLogado) {
		Page<Friend> friendsPageable = friendRepository.findAllWaitingFriends(FriendStatus.WAITING,
				profileLogado.getId(), pageable);
		List<ProfileDTO> listFriendsDTO = new ArrayList<>();

		friendsPageable.getContent().forEach(f -> {
			Profile friendProfile = profileBusiness.getProfile(f.getId().getProfile());

			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setId(friendProfile.getId());
			profileDTO.setGenre(friendProfile.getGenre());
			profileDTO.setName(friendProfile.getName());
			profileDTO.setUsername(friendProfile.getUser().getUsername());
			profileDTO.setCountry(friendProfile.getCountry());

			if (profileDTO.getAvatar() != null) {
				profileDTO.setAvatar(avatarStorage.getUrl(profileDTO.getAvatar()));
			}

			Long value = ratingRepository.compatibilityBetweenFriends(profileLogado.getId(), friendProfile.getId());
			profileDTO.setCompatibility(Compatibility.getCompatibility(Long.valueOf(value).intValue()));

			listFriendsDTO.add(profileDTO);

		});

		PageableResponse<ProfileDTO> pageableResponse = new PageableResponse<>();
		pageableResponse.setContent(listFriendsDTO);
		pageableResponse.setTotalPages(friendsPageable.getTotalPages());
		pageableResponse.setNumber(friendsPageable.getNumber());
		pageableResponse.setTotalElements(friendsPageable.getTotalElements());
		pageableResponse.setSize(friendsPageable.getSize());

		return pageableResponse;
	}

	@Override
	public Long getFriendsCount(String status) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser().get();
		if (status.equalsIgnoreCase(FriendStatus.ACCEPT.toString())) {
			return friendRepository.countFriends(FriendStatus.ACCEPT, profileLogado.getId());
		} else {
			return friendRepository.countWatingFriends(FriendStatus.WAITING, profileLogado.getId());
		}
	}

}
