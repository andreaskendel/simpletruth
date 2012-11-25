package de.kendel.simtru.model.backend.services.impl.demo;

import java.util.ArrayList;
import java.util.List;

import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.services.CommentService;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

public class CommentDemoService implements CommentService {

	private DemoDataGenerator demoDataGenerator = new DemoDataGenerator();
	
	@Override
	public List<Comment> getTeaserComments(int limit) {
		List<Comment> results = new ArrayList<Comment>();
		for (int i=0; i<limit; i++) {
			results.add(demoDataGenerator.createRandomComment());
		}
		return results;
	}

}
