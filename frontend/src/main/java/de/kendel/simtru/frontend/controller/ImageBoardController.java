package de.kendel.simtru.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageBoardController {
	@RequestMapping("imageboard")
	public String welcome() {
		return "imageboard";
	}
}
