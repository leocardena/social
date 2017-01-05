package com.social.storage;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Component
public class AvatarStorageS3 implements AvatarStorage {

	@Autowired
	private AmazonS3 amazonS3;

	@Override
	public String saveAvatar(MultipartFile avatar) {
		String avatarName = avatar.getOriginalFilename();
		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(avatar.getContentType());
			metadata.setContentLength(avatar.getSize());
			amazonS3.putObject("avatar", avatarName, avatar.getInputStream(), metadata);
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException("Erro salvando arquivo no S3", e);
		}

		return avatarName;
	}

	@Override
	public String getUrl(String avatarName) {
		return "http://localhost:9444/s3/avatar/" + avatarName + "?noAuth=true";
	}

}
