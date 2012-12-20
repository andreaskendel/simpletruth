package de.kendel.simtru.model.backend.services;

import java.util.List;

import de.kendel.simtru.model.backend.domain.User;

public interface UserService {
	List<User> findAll();
	User find(Long id);
	User findByUsername(String username);
	void save(User user);
}
