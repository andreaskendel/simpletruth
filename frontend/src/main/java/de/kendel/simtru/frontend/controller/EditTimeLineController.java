package de.kendel.simtru.frontend.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import de.kendel.simtru.frontend.model.EditComment;
import de.kendel.simtru.frontend.model.UploadItem;
import de.kendel.simtru.model.backend.domain.Comment;
import de.kendel.simtru.model.backend.domain.Discussion;
import de.kendel.simtru.model.backend.domain.Image;
import de.kendel.simtru.model.backend.services.CommentService;
import de.kendel.simtru.model.backend.services.DiscussionService;

@Controller
@SessionAttributes("editComment")
@RequestMapping("timeline/{discussionId}/edit/{commentId}")
public class EditTimeLineController {

	@Autowired
	DiscussionService discussionService;

	@Autowired
	CommentService commentService;

	@ModelAttribute("discussion")
	public Discussion addDiscussion(
			@PathVariable("discussionId") Long discussionId) {
		Discussion discussion = null;
		if (discussionId > 0) {
			discussion = discussionService.find(discussionId);
		}

		if (discussion == null) {
			discussion = new Discussion();
			discussion.setComments(new ArrayList<Comment>());
		}
		return discussion;
	}

	@ModelAttribute("comment")
	public Comment addComment(@PathVariable("commentId") Long commentId) {
		Comment comment = null;
		if (commentId > 0) {
			comment = commentService.find(commentId);
		}

		if (comment == null) {
			comment = new Comment();
		}

		return comment;
	}

	@ModelAttribute("editComment")
	public EditComment addEditComment(ModelMap model) {
		Comment comment = (Comment) model.get("comment");
		EditComment editComment = new EditComment();
		editComment.setComment(comment);
		editComment.setUploadItem(new UploadItem());
		return editComment;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editTimeLine(ModelMap model,
			@ModelAttribute Comment comment,
			@ModelAttribute Discussion discussion) {

		if (comment.isNew()) {
			discussion.getComments().add(comment);
			comment.setDiscussion(discussion);
		}

		return new ModelAndView("timeline", model);
	}

	@RequestMapping(method = RequestMethod.POST, params = "isUpload=true")
	public String uploadFileItem(ModelMap model,
			@ModelAttribute EditComment editComment,
			@ModelAttribute Discussion discussion) {
		Image image = new Image();
		image.setBytes(editComment.getUploadItem().getFileData().getBytes());
		editComment.getComment().setImage(image);
		return "redirect:/timeline/" + (discussion.isNew() ? "0" : discussion.getId()) + "/edit/0";
	}

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getUploadFileItem(@ModelAttribute EditComment editComment) {
		byte[] imageContent = new byte[0];
		try {
			imageContent = editComment.getComment().getImage().getBytes();
		} catch (NullPointerException e) {

		}
		return imageContent;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveTimeLine(ModelMap model, SessionStatus status,
			@ModelAttribute EditComment editComment) {

		Discussion discussion = editComment.getComment().getDiscussion();
		discussionService.save(discussion);
		status.setComplete();

		return "redirect:/timeline/" + discussion.getId();
	}
}
