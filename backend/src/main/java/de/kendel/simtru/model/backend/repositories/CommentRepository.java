package de.kendel.simtru.model.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import de.kendel.simtru.model.backend.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
