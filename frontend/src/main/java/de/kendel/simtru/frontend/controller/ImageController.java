package de.kendel.simtru.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import de.kendel.simtru.model.backend.domain.Image;
import de.kendel.simtru.model.backend.services.ImageService;

@Controller
public class ImageController {
	
	@Autowired
	ImageService imageService;

	@RequestMapping("image/{imageId}")
	@ResponseBody
	public byte[] getUploadFileItem(@PathVariable("imageId") Long imageId) {
		byte[] imageContent = new byte[0];
		try {
			Image image = imageService.find(imageId);
			if (image != null)
			{
				imageContent = image.getBytes();
			}
		} catch (NullPointerException e) {

		}
		return imageContent;
	}
	
}
