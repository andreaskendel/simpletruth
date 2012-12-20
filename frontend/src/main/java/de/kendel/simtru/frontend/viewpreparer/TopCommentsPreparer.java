package de.kendel.simtru.frontend.viewpreparer;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.springframework.beans.factory.annotation.Autowired;

import de.kendel.simtru.model.backend.services.CommentService;

public class TopCommentsPreparer implements ViewPreparer {

	@Autowired
	private CommentService commentService;
	
	@Override
	public void execute(TilesRequestContext context, AttributeContext attributes) {
		context.getRequestScope().put("teaserComments", commentService.getTeaserComments(5));	
	}

}
