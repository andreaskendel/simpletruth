package de.kendel.simtru.model.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.kendel.simtru.model.backend.domain.ImageThread;
import de.kendel.simtru.model.backend.repositories.ImageThreadRepository;
import de.kendel.simtru.model.backend.services.ImageThreadService;

public class ImageThreadServiceImpl implements ImageThreadService {

	@Autowired
	ImageThreadRepository imageThreadRepository;
	
	@Override
	public List<ImageThread> getTeaserImageThreads(int limit) {
		return null;
	}

}
