package com.social.business;

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
		friend.setFriend(profileFriend);
		friend.setProfile(profileLogado);
		friend.setStatus(FriendStatus.WAITING);
		
		return friendRepository.saveAndFlush(friend);
		
	}

}
