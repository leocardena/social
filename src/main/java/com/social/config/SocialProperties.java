package com.social.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "social", ignoreUnknownFields = false)
public class SocialProperties {

	private final Security security = new Security();
	private final Mail mail = new Mail();
    private final Async async = new Async();

	public Security getSecurity() {
		return security;
	}

	public Mail getMail() {
		return mail;
	}
	
	public Async getAsync() {
		return async;
	}

	public static class Mail {

		private String from = "support@social.com";

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}
	}

	public static class Security {

		private final Authentication authentication = new Authentication();

		public Authentication getAuthentication() {
			return authentication;
		}

		public static class Authentication {

			private final Jwt jwt = new Jwt();

			public Jwt getJwt() {
				return jwt;
			}

			public static class Jwt {

				private String secret;

				private long tokenValidityInSeconds = 1800;

				private long tokenValidityInSecondsForRememberMe = 2592000;

				public String getSecret() {
					return secret;
				}

				public void setSecret(String secret) {
					this.secret = secret;
				}

				public long getTokenValidityInSeconds() {
					return tokenValidityInSeconds;
				}

				public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
					this.tokenValidityInSeconds = tokenValidityInSeconds;
				}

				public long getTokenValidityInSecondsForRememberMe() {
					return tokenValidityInSecondsForRememberMe;
				}

				public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
					this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
				}
			}
		}
	}
	
    public static class Async {

        private int corePoolSize = 2;

        private int maxPoolSize = 50;

        private int queueCapacity = 10000;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

}
