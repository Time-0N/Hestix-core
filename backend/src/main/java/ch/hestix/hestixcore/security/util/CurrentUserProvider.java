package ch.hestix.hestixcore.security.util;

import ch.hestix.hestixcore.data.model.entity.User;
import ch.hestix.hestixcore.security.UserAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserProvider {

	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof UserAuthentication userAuth) {
			return (User) userAuth.getPrincipal();
		}

		throw new IllegalStateException("No authenticated user found in SecurityContext");
	}

	public boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}
}

