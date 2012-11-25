package de.kendel.simtru.model.backend.services;

import java.util.List;

import de.kendel.simtru.model.backend.domain.Comment;

public interface CommentService {
	List<Comment> getTeaserComments (int limit);
}
