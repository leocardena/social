package com.social.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import com.social.config.SocialProperties;
import com.social.domain.User;

@Service
public class MailBusiness {
	
    private static final String USER = "user";
    private static final String BASE_URL = "baseUrl";

	@Autowired
	private SocialProperties socialProperties;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	
	@Autowired
    private SpringTemplateEngine templateEngine;
	
	@Async
    public void sendEmail(String to, String content, boolean isHtml) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	        messageHelper.setFrom(socialProperties.getMail().getFrom());
	        messageHelper.setTo(to);
	        messageHelper.setSubject("Ativação de conta");
	        messageHelper.setText(content, isHtml);
	    };
        try {
        	javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }
	
    @Async
    public void sendActivationEmail(User user, String baseUrl) {
        Context context = new Context();
        context.setVariable(USER, user);
        context.setVariable(BASE_URL, baseUrl);
        String content = templateEngine.process("activationEmail", context);
        sendEmail(user.getEmail(), content, true);
    }
  
}
