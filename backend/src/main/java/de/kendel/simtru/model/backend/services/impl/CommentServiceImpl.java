package de.kendel.simtru.model.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.repositories.CommentRepository;
import de.kendel.simtru.model.backend.services.CommentService;

public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getTeaserComments(int limit) {
		Page<Comment> page = commentRepository.findAll(new PageRequest(0,
				limit, new Sort("createdDate")));
		if (page.hasContent()) {
			return page.getContent();
		} else {
			return new ArrayList<Comment>();
		}
	}

	@Override
	public Comment find(Long commentId) {
		return commentRepository.findOne(commentId);
	}

}
