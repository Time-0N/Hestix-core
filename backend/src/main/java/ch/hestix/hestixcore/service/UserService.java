package ch.hestix.hestixcore.service;

import ch.hestix.hestixcore.data.model.entity.User;
import ch.hestix.hestixcore.rest.generated.model.UserRegistrationRequest;
import ch.hestix.hestixcore.rest.generated.model.UserRegistrationResponse;
import ch.hestix.hestixcore.rest.generated.model.UserUpdateRequest;
import ch.hestix.hestixcore.rest.generated.model.UserUpdateResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
	UserUpdateResponse updateUser(User user, UserUpdateRequest request);
	UserRegistrationResponse registerUser(UserRegistrationRequest request);
	void deleteUser(UUID uuid);
	Optional<User> findByUsername(String username);
	User findById(UUID id);
	List<User> findAllUsers();
}
