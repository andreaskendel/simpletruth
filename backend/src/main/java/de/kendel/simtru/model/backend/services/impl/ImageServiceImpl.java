package de.kendel.simtru.model.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import de.kendel.simtru.model.backend.domain.Image;
import de.kendel.simtru.model.backend.repositories.ImageRepository;
import de.kendel.simtru.model.backend.services.ImageService;

public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public Image find(Long id) {
		return imageRepository.findOne(id);
	}

}
