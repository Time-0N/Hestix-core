package ch.hestix.hestixcore.data.repository;

import ch.hestix.hestixcore.data.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findById(UUID id);
	Optional<User> findByUsername(String username);

	boolean existsByUsernameOrEmail(String username, String email);

	@Transactional(readOnly = true)
	Optional<User> findByKeycloakId(String keycloakId);

	@Transactional(readOnly = true)
	boolean existsByEmail(String email);

	@Transactional(readOnly = true)
	boolean existsByUsername(String username);
}
