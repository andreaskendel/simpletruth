package de.kendel.simtru.model.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.repositories.DiscussionRepository;
import de.kendel.simtru.model.backend.services.DiscussionService;

public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	private DiscussionRepository discussionRepository;

	@Override
	public List<Discussion> findAll() {
		return discussionRepository.findAll();
	}

	@Override
	public Discussion find(Long id) {
		return discussionRepository.findOne(id);
	}

	@Override
	public Discussion getNewestDiscussion() {
		Page<Discussion> page = discussionRepository.findAll(new PageRequest(0,
				1, new Sort("createdDate")));
		
		Discussion discussion = null; 
		if (page.hasContent()) {
			discussion = page.getContent().get(0);
		}
		return discussion;
	}

	@Override
	public void save(Discussion discussion) {
		discussionRepository.save(discussion);
	}

}
