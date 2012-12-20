package de.kendel.simtru.model.service;

import static junit.framework.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import de.kendel.simtru.model.backend.domain.Role;
import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.services.UserService;

public class UserServiceTest extends ServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	@Transactional
	@Rollback
	public void testFindAdminUser()
	{
		User user = userService.findByUsername("admin");
		assertNotNull(user);
		assertTrue(user.getRoles().contains(Role.ADMIN));
	}
}
