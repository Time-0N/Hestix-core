package ch.hestix.hestixcore.config.keycloak;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "keycloak")
@Getter
@Setter
public class KeycloakProperties {
	private String authServerUrl;
	private String realm;
	private String clientId;
	private String clientSecret;
	private String tokenUri;
}
