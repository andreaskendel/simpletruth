package de.kendel.simtru.model.backend.services;

import de.kendel.simtru.model.backend.domain.Image;

public interface ImageService {
	Image find(Long id);
}
