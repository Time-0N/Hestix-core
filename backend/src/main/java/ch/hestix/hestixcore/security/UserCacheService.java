package ch.hestix.hestixcore.security;

import ch.hestix.hestixcore.data.model.entity.User;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Service
public class UserCacheService {
	private final Cache<String, User> cache = Caffeine.newBuilder()
			.expireAfterWrite(5, TimeUnit.MINUTES)
			.maximumSize(1000)
			.build();

	public void invalidate(String keycloakId) {
		cache.invalidate(keycloakId);
	}

	public User getOrLoad(String keycloakId, Supplier<User> loader) {
		return cache.get(keycloakId, k -> loader.get());
	}

	public void evict(String keycloakId) {
		cache.invalidate(keycloakId);
	}

	public void clearAll() {
		cache.invalidateAll();
	}
}
