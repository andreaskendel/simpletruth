package de.kendel.simtru.frontend.controller.image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {

	@RequestMapping("image/upload")
	public String showImageUpload() {
		return "upload";
	}
}