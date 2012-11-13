package de.kendel.simtru.model.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.kendel.simtru.model.backend.domain.User;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/tests/repository-context.xml")
public class UserRepositoryTest {
	
	@Autowired
	DemoDataGenerator testDataGenerator;
	
	@Test
	public void TestSaveUser()
	{
		User user = testDataGenerator.createNewUser();
	}

}
