package com.social.storage;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarStorage {

	public String saveAvatar(MultipartFile avatar, String avatarName);
	public void deleteAvatar(String avatarKey);
	public String getUrl(String avatarName);

}
