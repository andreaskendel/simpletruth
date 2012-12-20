<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<tiles:importAttribute name="currComment"/>
<tiles:importAttribute name="isLast"/>
<div class="comment">
	<div>${currComment.createdBy.displayName}</div>
	<spring:url value="/image/${currComment.image.id}" var="imageUrl"/>
	<img src="${imageUrl}" />
	<div>${currComment.text}</div>
	<c:if test="${isLast}">
		<spring:url value="/timeline/${discussion.id}/edit/0" var="addCommentUrl" />
		<a href="${addCommentUrl}">add comment</a>
	</c:if>
</div>