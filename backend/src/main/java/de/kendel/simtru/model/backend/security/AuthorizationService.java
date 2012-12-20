package de.kendel.simtru.model.backend.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import de.kendel.simtru.model.backend.domain.User;

public class AuthorizationService {

	public static User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
			return ((SimtruUserDetails) auth.getPrincipal()).getUser();

		}
		return null;
	}

	public static void authorizeUser(User user) {
		Authentication auth = new UsernamePasswordAuthenticationToken(
				new SimtruUserDetails(user), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

	public static void deAuthorize() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
}
