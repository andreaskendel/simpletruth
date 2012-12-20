package de.kendel.simtru.frontend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.services.DiscussionService;

@Controller
public class ImageBoardController {
	@Autowired
	DiscussionService discussionService;
	
	@RequestMapping("imageboard")
	public ModelAndView showImageBoard() {
		Map<String,Object> model = new HashMap<String, Object>();
		dispatchDiscussions(model, discussionService.findAll());
		return new ModelAndView("imageboard", model);
	}
	
	private void dispatchDiscussions(Map<String,Object> model, List<Discussion> discussions)
	{
		List<Discussion> row1 = new ArrayList<Discussion>();
		List<Discussion> row2 = new ArrayList<Discussion>();
		List<Discussion> row3 = new ArrayList<Discussion>();
		for (Discussion discussion : discussions)
		{
			if (discussion.getId() % 3 == 0)
			{
				row1.add(discussion);
			} else if (discussion.getId() % 3 == 1) {
				row2.add(discussion);
			} else if (discussion.getId() % 3 == 2) {
				row3.add(discussion);
			}
		}
		model.put("row1", row1);
		model.put("row2", row2);
		model.put("row3", row3);
	}
}
