package de.kendel.simtru.model.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import de.kendel.simtru.model.backend.domain.Discussion;

public interface DiscussionRepository extends CrudRepository<Discussion, Long> {
	List<Discussion> findAll();
	Page<Discussion> findAll(Pageable pageable);
}
