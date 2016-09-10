package com.social.rest.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger log = LoggerFactory.getLogger(MailBusiness.class);

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
			log.debug("Email enviado para o usuário: '{}'", to);
		} catch (MailException e) {
			log.warn("E-mail não pode ser enviado para o usuário '{}', exception: {}", to, e.getMessage());
		}
	}

	@Async
	public void sendActivationEmail(User user, String baseUrl) {
        log.debug("Enviando e-mail de ativação para: '{}'", user.getEmail());
		Context context = new Context();
		context.setVariable(USER, user);
		context.setVariable(BASE_URL, baseUrl);
		String content = templateEngine.process("activationEmail", context);
		sendEmail(user.getEmail(), content, true);
	}

}
