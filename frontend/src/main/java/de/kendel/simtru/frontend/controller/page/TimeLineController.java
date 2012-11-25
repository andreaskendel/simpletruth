package de.kendel.simtru.frontend.controller.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.services.DiscussionService;

@Controller
@RequestMapping("timeline")
public class TimeLineController {
	
	@Autowired
	DiscussionService discussionService;
	
	@RequestMapping("{id}")
	public ModelAndView showTimeLine(@PathVariable("id") Long id)
	{
		Map<String, Object> model = new HashMap<String, Object>();
		
		Discussion discussion = discussionService.find(id);
		model.put("discussion", discussion);
		
		Comment newComment = new Comment();
		model.put("editComment", newComment);
		
		discussion.getComments().add(newComment);
		newComment.setDiscussion(discussion);
		
		return new ModelAndView("timeline", model);
	}
	
	@RequestMapping("new")
	public ModelAndView createTimeLine()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		
		Discussion discussion = new Discussion();
		model.put("discussion", discussion);
		
		Comment newComment = new Comment();
		model.put("editComment", newComment);
		
		discussion.setComments(new ArrayList<Comment>());
		discussion.getComments().add(newComment);
		newComment.setDiscussion(discussion);
		
		return new ModelAndView("timeline", model);
	}
	
}
