package de.kendel.simtru.model.backend.services;

import java.util.List;

import de.kendel.simtru.model.backend.domain.ImageThread;

public interface ImageThreadService {

	List<ImageThread> getTeaserImageThreads (int limit);
	
}
