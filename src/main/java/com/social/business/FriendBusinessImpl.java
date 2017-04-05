package com.social.business;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.social.business.interfaces.AccountBusiness;
import com.social.business.interfaces.FriendBusiness;
import com.social.business.interfaces.ProfileBusiness;
import com.social.domain.Friend;
import com.social.domain.FriendPK;
import com.social.domain.Profile;
import com.social.repository.FriendRepository;
import com.social.repository.ProfileRepository;
import com.social.util.FriendStatus;
import com.social.web.rest.dto.FriendDTO;
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
	private ProfileRepository profileRepository;

	@Override
	public FriendDTO postFriend(FriendVM friendVM) {

	    Optional<Profile> friendProfile = profileRepository.findOneById(friendVM.getIdFriend());
	    
	    if (!friendProfile.isPresent())
			throw new ResourceNotFoundException("Amigo não encontrado");
	    
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();

		FriendPK friendPK = new FriendPK(profileLogado, friendProfile.get());
		Friend friend = new Friend();
		friend.setId(friendPK);
		friend.setStatus(FriendStatus.WAITING);
		Friend friendPersistido = friendRepository.save(friend);

		return FriendDTO.build(friendPersistido);

	}

	@Override
	public FriendDTO getFriend(Long idFriend) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		
		Optional<Friend> friendOptinal = friendRepository.findFriendsById(profileLogado.getId(), idFriend);

		if (!friendOptinal.isPresent())
			throw new ResourceNotFoundException("Amigo não encontrado");

		return FriendDTO.build(friendOptinal.get());
	}

	@Override
	public void deleteFriend(Long idFriend) {

		Profile friendSearch = profileBusiness.getProfile(idFriend);
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		FriendPK friendPK = new FriendPK(profileLogado, friendSearch);

		friendRepository.delete(friendPK);

	}

	@Override
	public FriendDTO patchFriend(FriendStatusVM status, Long idFriend) {
		Profile profileLogado = accountBussiness.findProfileByLoggedUser();
		
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

}
