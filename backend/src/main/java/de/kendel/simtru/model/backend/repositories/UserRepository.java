package de.kendel.simtru.model.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.kendel.simtru.model.backend.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
