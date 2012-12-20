package de.kendel.simtru.frontend.model;

import de.kendel.simtru.model.backend.domain.Comment;

public class EditComment {
	private Comment comment;
	private UploadItem uploadItem;
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public UploadItem getUploadItem() {
		return uploadItem;
	}

	public void setUploadItem(UploadItem uploadItem) {
		this.uploadItem = uploadItem;
	}
}
