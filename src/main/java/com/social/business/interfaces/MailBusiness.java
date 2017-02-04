package com.social.business.interfaces;

import org.springframework.scheduling.annotation.Async;
import com.social.domain.User;

public interface MailBusiness {
	
	@Async
	public void sendEmail(String to, String content, boolean isHtml);
	
	@Async
	public void sendActivationEmail(User user, String baseUrl);

}
