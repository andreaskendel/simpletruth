<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div>timeline</div>

<c:forEach var="currComment" items="${discussion.comments}" varStatus="status">
	<c:choose>
		<c:when
			test="${currComment.id eq editComment.comment.id}">
			<tiles:insertTemplate template="edit.jsp">
				<tiles:putAttribute name="editComment" value="${editComment}" />
			</tiles:insertTemplate>
		</c:when>
		<c:otherwise>
			<tiles:insertTemplate template="comment.jsp">
				<tiles:putAttribute name="currComment" value="${currComment}" />
				<tiles:putAttribute name="isLast" value="${status.last}" />
			</tiles:insertTemplate>
		</c:otherwise>
	</c:choose>
</c:forEach>