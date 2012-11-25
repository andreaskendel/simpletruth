<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div>timeline</div>

<c:forEach var="comment" items="${discussion.comments}">
	<c:choose>
		<c:when
			test="${comment.id eq editComment.id}">
			<tiles:insertTemplate template="edit.jsp">
				<tiles:putAttribute name="comment" value="${editComment}" />
			</tiles:insertTemplate>
		</c:when>
		<c:otherwise>
			<tiles:insertTemplate template="comment.jsp">
				<tiles:putAttribute name="comment" value="${comment}" />
			</tiles:insertTemplate>
		</c:otherwise>
	</c:choose>

</c:forEach>