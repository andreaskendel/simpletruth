package de.kendel.simtru.model.backend.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import de.kendel.simtru.model.backend.domain.User;

public class DemoDataGenerator {
	
	List<User> userList = new ArrayList<User>();
	Random random = new Random();
	
	public DemoDataGenerator() {
		userList.add(createNewUser("Thomas Gurde"));
		userList.add(createNewUser("Heinz Westermaier"));
		userList.add(createNewUser("Friede Gutlust"));
		userList.add(createNewUser("Roman the Schowman"));
		userList.add(createNewUser("Tommy Kanone"));
		userList.add(createNewUser("Das Syndicat"));
		userList.add(createNewUser("Steffan Rölenknut"));
		userList.add(createNewUser("Benjamin Franzki"));
		userList.add(createNewUser("Andreas Kendel"));
	}
	
	public User getRandomUser()
	{
		return userList.get(random.nextInt(userList.size()));
	}

	public User createNewUser(String displayName)
	{
		User user = new User();
		user.setDisplayName(displayName);
		user.setUserName(displayName.toLowerCase().replaceAll(" ", ""));
		user.setPassword("geheim");
		user.setLastLogin(new Date());
		return user;
	}
	
	public String createRandomText()
	{
		return null;
	}
}
