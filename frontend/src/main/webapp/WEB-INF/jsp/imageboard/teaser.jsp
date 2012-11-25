<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<tiles:importAttribute name="discussion" />

<div class="imagebox">
	<div class="contentWrapper hidden">
		<div class="content">
			<c:forEach var="comment" items="${discussion.comments}">
				<div class="entry">
					<h5>${comment.createdBy.displayName}</h5>
					<div class="date">
						<joda:format value="${comment.createdDate}" pattern="dd MMMM yyyy HH:mm"/>
					</div>
					<p>${comment.text}</p>
				</div>
			</c:forEach>
		</div>
	</div>
	<c:choose>
		<c:when test="${not empty discussion.comments[0].image}">
			<c:set var="imagePath" value="comming soon" />
		</c:when>
		<c:otherwise>
			<c:set var="imagePath"><spring:theme code="content.noimage"/></c:set>
		</c:otherwise>
	</c:choose>
	<c:set var="imageUrl">
		<spring:url value="${imagePath}" />
	</c:set>
	<img class="image" src="${imageUrl}" />
</div>