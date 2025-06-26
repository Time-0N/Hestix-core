package ch.hestix.hestixcore.mapper;

import ch.hestix.hestixcore.rest.generated.model.User;

public class UserMapper {

	public static User toRest(ch.hestix.hestixcore.data.model.entity.User entity) {
		if (entity == null) return null;

		return new User(
				entity.getUsername(),
				entity.getEmail(),
				entity.getFirstName(),
				entity.getLastName()
		);
	}
}
