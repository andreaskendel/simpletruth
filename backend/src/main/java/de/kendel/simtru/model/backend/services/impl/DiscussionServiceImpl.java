package de.kendel.simtru.model.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.repositories.DiscussionRepository;
import de.kendel.simtru.model.backend.services.DiscussionService;

public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	DiscussionRepository discussionRepository;

	@Override
	public List<Discussion> findAll() {
		return discussionRepository.findAll();
	}

	@Override
	public Discussion find(Long id) {
		return discussionRepository.findOne(id);
	}

}
