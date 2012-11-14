package de.kendel.simtru.model.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/tests/domain-context.xml")
public class UserTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

	@Autowired
	private DemoDataGenerator testDataGenerator;
	
	@Test
	public void testToString() {
		User user = testDataGenerator.createNewUser("toString Testuser");
		logger.debug("testToString - {}", user.toString());
	}

}
