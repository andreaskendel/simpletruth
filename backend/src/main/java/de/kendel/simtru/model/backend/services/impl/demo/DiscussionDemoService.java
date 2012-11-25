package de.kendel.simtru.model.backend.services.impl.demo;

import java.util.ArrayList;
import java.util.List;


import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.services.DiscussionService;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

public class DiscussionDemoService implements DiscussionService{

	private DemoDataGenerator demoDataGenerator = new DemoDataGenerator();
	
	@Override
	public List<Discussion> findAll() {
		List<Discussion> result = new ArrayList<Discussion>();
		for(int i = 0; i < 20; i++)
		{
			result.add(demoDataGenerator.createRandomDiscussion());
		}
		return result;
	}

	@Override
	public Discussion find(Long id) {
		return demoDataGenerator.createRandomDiscussion();
	}

}
