package de.kendel.simtru.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.services.DiscussionService;

@Controller
@RequestMapping("timeline")
public class TimeLineController {

	@Autowired
	DiscussionService discussionService;
	
	@RequestMapping
	public String showTimeLine() {
		Discussion discussion = discussionService.getNewestDiscussion();
		if (discussion == null)
		{
			return "redirect:/imageboard/";
		}
		return "redirect:/timeline/" + discussion.getId();
	}

	@RequestMapping("{discussionId}")
	public ModelAndView showTimeLine(@PathVariable("discussionId") Long id) {
		ModelAndView modelAndView = new ModelAndView("timeline");
		modelAndView.addObject("discussion", discussionService.find(id));
		return modelAndView;
	}

	@RequestMapping("new")
	public String newTimeLine() {
		return "redirect:/timeline/0/edit/0";
	}	
}
