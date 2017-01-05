package com.social.storage;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarStorage {

	public String saveAvatar(MultipartFile avatar);
	public String getUrl(String avatarName);

}
