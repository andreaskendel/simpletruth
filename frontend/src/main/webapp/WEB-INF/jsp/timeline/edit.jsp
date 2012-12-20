<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>form</div>
<tiles:importAttribute name="editComment" scope="request" />

<c:set var="discussionId">
	<c:out value="${discussion.id}" default="0" />
</c:set>
<c:set var="commentId">
	<c:out value="${editComment.comment.id}" default="0" />
</c:set>
<spring:url value="/timeline/${discussionId}/edit/${commentId}"
	var="postUrl" />
	
<form:form method="post" action="${postUrl}"
	modelAttribute="editComment" enctype="multipart/form-data">
	<form:input path="comment.text" />
	<form:input id="uploadItem" path="uploadItem.fileData" type="file" />
	<input type="hidden" name="isUpload" value="false" />
	<input type="submit" value="Add Comment" />
</form:form>

<img src="${postUrl}/upload" />