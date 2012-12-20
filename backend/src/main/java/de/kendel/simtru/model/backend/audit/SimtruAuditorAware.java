package de.kendel.simtru.model.backend.audit;

import org.springframework.data.domain.AuditorAware;

import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.security.AuthorizationService;

public class SimtruAuditorAware implements AuditorAware<User> {

	@Override
	public User getCurrentAuditor() {
		return AuthorizationService.getCurrentUser();
	}

}
