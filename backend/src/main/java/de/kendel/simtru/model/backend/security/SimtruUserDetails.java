package de.kendel.simtru.model.backend.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import de.kendel.simtru.model.backend.domain.Role;
import de.kendel.simtru.model.backend.domain.User;

public class SimtruUserDetails implements UserDetails {
	private static final long serialVersionUID = -899608063640963997L;
	public User user;
	
	public SimtruUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles())
		{
			authorities.add(new SimpleGrantedAuthority(role.toString()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getDisplayName() {
		return user.getDisplayName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getIsActive();
	}
	
	public User getUser()
	{
		return user;
	}
}
