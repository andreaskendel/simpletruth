package de.kendel.simtru.model.domain;

import org.junit.Test;

import de.kendel.simtru.model.backend.domain.User;

public class UserTest extends DomainTest {
	
	@Test
	public void testToString() {
		User user = new User();
		logger.debug("testToString - {}", user.toString());
	}

}
