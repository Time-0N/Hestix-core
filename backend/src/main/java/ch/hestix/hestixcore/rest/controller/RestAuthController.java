package ch.hestix.hestixcore.rest.controller;

import ch.hestix.hestixcore.rest.generated.AuthApi;
import ch.hestix.hestixcore.rest.generated.model.AuthenticationRequest;
import ch.hestix.hestixcore.rest.generated.model.TokenResponse;
import ch.hestix.hestixcore.rest.generated.model.UserRegistrationRequest;
import ch.hestix.hestixcore.rest.generated.model.UserRegistrationResponse;
import ch.hestix.hestixcore.service.KeycloakService;
import ch.hestix.hestixcore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RestAuthController implements AuthApi {

	private final UserService userService;
	private final KeycloakService keycloakService;

	@Override
	@PostMapping("/token")
	public ResponseEntity<TokenResponse> loginUser(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
		TokenResponse tokenResponse = keycloakService.authenticateUser(authenticationRequest);
		return ResponseEntity.ok(tokenResponse);
	}

	@Override
	@PostMapping("/register")
	public ResponseEntity<UserRegistrationResponse> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		UserRegistrationResponse response = userService.registerUser(userRegistrationRequest);
		return ResponseEntity.ok(response);
	}
}
