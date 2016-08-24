package com.social.config;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "social", ignoreUnknownFields = false)
public class SocialProperties {

	private final Security security = new Security();
    private final Mail mail = new Mail();

	public Security getSecurity() {
		return security;
	}
	
    public Mail getMail() {
        return mail;
    }

    public static class Mail {

        private String from = "social.moviesandshows@gmail.com";

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

	public static class Security {

		private final RememberMe rememberMe = new RememberMe();

		public RememberMe getRememberMe() {
			return rememberMe;
		}

		public static class RememberMe {

			@NotNull
			private String key;

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}
		}
	}

}
