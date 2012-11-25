package de.kendel.simtru.model.backend.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;

import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.domain.User;
import de.svenjacobs.loremipsum.LoremIpsum;

public class DemoDataGenerator {
	
	List<User> userList = new ArrayList<User>();
	Random random = new Random();
	private LoremIpsum loremIpsum = new LoremIpsum();
	
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
		User user = new User(random.nextLong());
		user.setDisplayName(displayName);
		user.setUserName(displayName.toLowerCase().replaceAll(" ", ""));
		user.setPassword("geheim");
		user.setLastLogin(new Date());
		return user;
	}
	
	public Comment createRandomComment()
	{
		Comment comment = new Comment(random.nextLong());
		comment.setCreatedBy(getRandomUser());
		comment.setText(createRandomText());
		DateTime createDate = new DateTime();
		createDate.minusDays(random.nextInt(30));
		createDate.minusHours(random.nextInt(13));
		comment.setCreatedDate(createDate);
		return comment;
	}
	
	private String createRandomText() {
		return loremIpsum.getParagraphs(1);
	}

	public Discussion createRandomDiscussion()
	{
		Discussion discussion = new Discussion(random.nextLong());
		discussion.setComments(new ArrayList<Comment>());
		DateTime createDate = new DateTime();
		createDate.minusDays(random.nextInt(30));
		createDate.minusHours(random.nextInt(13));
		discussion.setCreatedDate(createDate);
		discussion.setCreatedBy(getRandomUser());
		
		for (int i = 0; i < random.nextInt(10); i++)
		{
			discussion.getComments().add(createRandomComment());
		}
		return discussion;
	}
}
