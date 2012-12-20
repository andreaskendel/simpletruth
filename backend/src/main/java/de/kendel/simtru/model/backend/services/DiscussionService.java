package de.kendel.simtru.model.backend.services;

import java.util.List;

import de.kendel.simtru.model.backend.domain.Discussion;

public interface DiscussionService {

	List<Discussion> findAll();
	Discussion find(Long id);
	void save(Discussion discussion);
	Discussion getNewestDiscussion();
}
