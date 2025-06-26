package ch.hestix.hestixcore.rest.controller;

import ch.hestix.hestixcore.mapper.UserMapper;
import ch.hestix.hestixcore.rest.generated.UserApi;
import ch.hestix.hestixcore.rest.generated.model.User;
import ch.hestix.hestixcore.rest.generated.model.UserUpdateRequest;
import ch.hestix.hestixcore.rest.generated.model.UserUpdateResponse;
import ch.hestix.hestixcore.security.UserCacheService;
import ch.hestix.hestixcore.security.util.CurrentUserProvider;
import ch.hestix.hestixcore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class RestUserController implements UserApi {
	private final UserService userService;
	private final UserCacheService userCacheService;
	private final CurrentUserProvider currentUserProvider;

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/admin/update-user/{userId}")
	public ResponseEntity<UserUpdateResponse> adminUpdateUser(@PathVariable String userId, UserUpdateRequest userUpdateRequest) {
		return ResponseEntity.ok(userService.updateUser(userService.findById(UUID.fromString(userId)), userUpdateRequest));
	}

	@Override
	@DeleteMapping("/delete/User")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteUser() {
		ch.hestix.hestixcore.data.model.entity.User currentUser = currentUserProvider.getCurrentUser();
		userService.deleteUser(currentUser.getId());
		userCacheService.evict(currentUser.getKeycloakId());

		return ResponseEntity.noContent().build();
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/admin/delete-user/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> adminDeleteUserById(@PathVariable String userId) {
		userService.deleteUser(UUID.fromString(userId));
		return ResponseEntity.noContent().build();
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/get/all")
	public ResponseEntity<List<Map<String, User>>> getAllUsers() {
		return ResponseEntity.ok(
				userService.findAllUsers().stream()
						.map(user -> Map.of(user.getId().toString(), UserMapper.toRest(user)))
						.toList()
		);
	}

	@Override
	@GetMapping("/me")
	public ResponseEntity<User> getCurrentUser() {
		ch.hestix.hestixcore.data.model.entity.User currentUser = currentUserProvider.getCurrentUser();
		return ResponseEntity.ok(UserMapper.toRest(currentUser));
	}

	@Override
	@PutMapping("/update/user")
	public ResponseEntity<UserUpdateResponse> updateUser(UserUpdateRequest userUpdateRequest) {
		ch.hestix.hestixcore.data.model.entity.User currentUser = currentUserProvider.getCurrentUser();
		return ResponseEntity.ok(userService.updateUser(currentUser, userUpdateRequest));
	}
}

