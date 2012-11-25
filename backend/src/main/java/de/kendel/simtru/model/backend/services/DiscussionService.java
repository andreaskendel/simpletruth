package de.kendel.simtru.model.backend.services;

import java.util.List;

import de.kendel.simtru.model.backend.domain.Discussion;

public interface DiscussionService {

	public List<Discussion> findAll();
	public Discussion find(Long id);
}
