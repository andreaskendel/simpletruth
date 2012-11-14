package de.kendel.simtru.model.repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.repositories.UserRepository;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/tests/repository-context.xml")
public class UserRepositoryTest {
	
	@Autowired
	private DemoDataGenerator testDataGenerator;
	
	@Autowired
	private UserRepository userRepositroy;
	
	@Test
	public void TestSaveUser()
	{
		User user = testDataGenerator.createNewUser("TestUser Save");
		userRepositroy.save(user);
		
		List<User> persistentUser = userRepositroy.findAll();
		assertEquals(user, persistentUser.get(0));
	}

}
