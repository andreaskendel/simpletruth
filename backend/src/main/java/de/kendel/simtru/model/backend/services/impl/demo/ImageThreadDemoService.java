package de.kendel.simtru.model.backend.services.impl.demo;

import java.util.ArrayList;
import java.util.List;


import de.kendel.simtru.model.backend.domain.ImageThread;
import de.kendel.simtru.model.backend.services.ImageThreadService;
import de.kendel.simtru.model.backend.util.DemoDataGenerator;

public class ImageThreadDemoService implements ImageThreadService{

	private DemoDataGenerator demoDataGenerator = new DemoDataGenerator();
	
	@Override
	public List<ImageThread> getTeaserImageThreads(int limit) {
		List<ImageThread> result = new ArrayList<ImageThread>();
		for(int i = 0; i < limit; i++)
		{
			result.add(demoDataGenerator.createRandomThread());
		}
		return null;
	}

}
