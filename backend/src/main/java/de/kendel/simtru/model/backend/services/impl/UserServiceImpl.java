package de.kendel.simtru.model.backend.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import de.kendel.simtru.model.backend.domain.Role;
import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.repositories.UserRepository;
import de.kendel.simtru.model.backend.services.UserService;

public class UserServiceImpl implements UserService, InitializingBean {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StandardPasswordEncoder passwordEncoder;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User find(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		if (StringUtils.isNotBlank(user.getNewPassword()))
		{
			user.setPassword(passwordEncoder.encode(user.getNewPassword()));
		}
		userRepository.save(user);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		User rootUser = createRootUser();
		if (findByUsername(rootUser.getUsername()) == null)
		{
			this.save(rootUser);
		}
	}
	
	private User createRootUser()
	{
		User user = new User();
		user.setUsername("admin");
		user.setDisplayName("Administrator");
		user.setNewPassword("test");
		user.setIsActive(true);
		
		Set<Role> adminRoles = new HashSet<Role>();
		adminRoles.add(Role.USER);
		adminRoles.add(Role.ADMIN);
		user.setRoles(adminRoles);
		
		return user;
	}

}
