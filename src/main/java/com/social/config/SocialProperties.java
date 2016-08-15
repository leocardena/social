package com.social.config;

import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "social", ignoreUnknownFields = false)
public class SocialProperties {

	private final Security security = new Security();

	public Security getSecurity() {
		return security;
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
