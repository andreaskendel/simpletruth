<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="subnavi hidden">
	<c:forEach var="comment" items="${teaserComments}" varStatus="status">
		<div class="entry">
			<h5>${comment.createdBy.displayName}</h5>
			<p>${fn:substring(comment.text, 0, 80)}...</p>
			<p>
				<spring:url value="/timeline/${comment.discussion.id}#${comment.id}"
					var="moreUrl" />
				<a href="${moreUrl}" class="morelink">mehr lesen</a>
			</p>
		</div>
		<c:if test="${!status.last}">
			<hr />
		</c:if>
	</c:forEach>
</div>