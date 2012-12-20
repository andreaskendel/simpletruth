package de.kendel.simtru.model.service;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.repositories.CommentRepository;
import de.kendel.simtru.model.backend.repositories.UserRepository;
import de.kendel.simtru.model.backend.security.AuthorizationService;
import de.kendel.simtru.model.backend.services.CommentService;

public class CommentServiceTest extends ServiceTest {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	@Transactional
	@Rollback
	public void testSaveAndFind()
	{
		Comment comment = new Comment();
		comment.setText("test");
		commentRepository.save(comment);
		
		Comment persistedComment = commentService.find(comment.getId());
		Assert.assertEquals("test", persistedComment.getText());		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testSaveAndFindWithAuditor()
	{
		User user = new User();
		user.setPassword("geheim");
		user.setUsername("auditor");
		userRepository.save(user);
		AuthorizationService.authorizeUser(user);
		
		Comment comment = new Comment();
		comment.setText("test");
		commentRepository.save(comment);
		
		Comment persistedComment = commentService.find(comment.getId());
		Assert.assertEquals("test", persistedComment.getText());
		Assert.assertNotNull(persistedComment.getCreatedBy());
		Assert.assertNotNull(persistedComment.getCreatedDate());
		Assert.assertEquals("auditor", persistedComment.getCreatedBy().getUsername());
		
		AuthorizationService.deAuthorize();
	}
	
	@Test
	@Transactional
	@Rollback
	public void testTeaserComments()
	{
		Comment comment = new Comment();
		comment.setText("test1");
		DateTime date1 = new DateTime();
		date1.minusHours(1);
		comment.setCreatedDate(date1);
		commentRepository.save(comment);
		
		comment = new Comment();
		comment.setText("test2");
		DateTime date2 = new DateTime();
		date1.minusHours(2);
		comment.setCreatedDate(date2);
		commentRepository.save(comment);
		
		comment = new Comment();
		comment.setText("test3");
		DateTime date3 = new DateTime();
		date1.minusHours(3);
		comment.setCreatedDate(date3);
		commentRepository.save(comment);
		
		comment = new Comment();
		comment.setText("test4");
		DateTime date4 = new DateTime();
		date1.minusHours(4);
		comment.setCreatedDate(date4);
		commentRepository.save(comment);
		
		List<Comment> persistedComments = commentService.getTeaserComments(1);
		Assert.assertEquals("test1", persistedComments.get(0).getText());
		
		persistedComments = commentService.getTeaserComments(2);
		Assert.assertEquals("test1", persistedComments.get(0).getText());
		Assert.assertEquals("test2", persistedComments.get(1).getText());
		
		persistedComments = commentService.getTeaserComments(3);
		Assert.assertEquals("test1", persistedComments.get(0).getText());
		Assert.assertEquals("test2", persistedComments.get(1).getText());
		Assert.assertEquals("test3", persistedComments.get(2).getText());
	}
}
