package de.kendel.simtru.model.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.services.UserService;

public class SimtruUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userService.findByUsername(username);
		if (user == null)
		{
			throw new UsernameNotFoundException("User unknown");
		}
		
		return new SimtruUserDetails(user);
	}
}
