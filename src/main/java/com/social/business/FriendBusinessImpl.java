package com.social.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.FriendBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Friend;
import com.social.domain.FriendPK;
import com.social.domain.Profile;
import com.social.repository.FriendRepository;
import com.social.util.FriendStatus;
import com.social.web.rest.dto.FriendDTO;
import com.social.web.rest.dto.ProfileDTO;
import com.social.web.rest.vm.FriendVM;

@Service
public class FriendBusinessImpl implements FriendBusiness {

	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private AccountBusiness accountBussiness;
	
	@Autowired
	private ProfileBusiness profileBusiness;
	
	@Override
	public Friend postFriend(FriendVM friendVM) {
		
		ProfileDTO profileDTO = profileBusiness.getProfile(friendVM.getUsername());
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		
		Profile profileFriend = new Profile();
		profileFriend.setId(profileDTO.getId());
		profileFriend.setCountry(profileDTO.getCountry());
		profileFriend.setName(profileDTO.getName());
		profileFriend.setGenre(profileDTO.getGenre());
		profileFriend.setAvatar(profileDTO.getAvatar());
		
		FriendPK friendPK = new FriendPK(profileLogado, profileFriend);
		Friend friend = new Friend();
		friend.setId(friendPK);
		friend.setStatus(FriendStatus.WAITING);
		
		return friendRepository.saveAndFlush(friend);
		
	}

	@Override
	public FriendDTO getFriend(Long idProfile) {

		Profile friendSearch = profileBusiness.getProfile(idProfile);
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		
		FriendPK friendPK = new FriendPK(profileLogado, friendSearch);
		Optional<Friend> friend = friendRepository.findOneById(friendPK);
		
		FriendDTO friendDto = new FriendDTO();
		friendDto.setId(friend.get().getId());
		friendDto.setStatus(friend.get().getStatus().toString());
		
		return friendDto;
	}

	@Override
	public void deleteFriend(Long idFriend) {
		
		Profile friendSearch = profileBusiness.getProfile(idFriend);
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		FriendPK friendPK = new FriendPK(profileLogado, friendSearch);
		
		friendRepository.delete(friendPK);
		
	}

	@Override
	public FriendDTO putFriend(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
