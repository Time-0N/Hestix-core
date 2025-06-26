package ch.hestix.hestixcore.service;

import ch.hestix.hestixcore.rest.generated.model.AuthenticationRequest;
import ch.hestix.hestixcore.rest.generated.model.TokenResponse;
import ch.hestix.hestixcore.rest.generated.model.UserRegistrationRequest;
import ch.hestix.hestixcore.rest.generated.model.UserUpdateRequest;

public interface KeycloakService {
	String createKeycloakUser(UserRegistrationRequest request);
	TokenResponse authenticateUser(AuthenticationRequest request);
	void deleteKeycloakUser(String keycloakUserId);
	void updateKeycloakUser(String keycloakUserId, UserUpdateRequest request);
}
