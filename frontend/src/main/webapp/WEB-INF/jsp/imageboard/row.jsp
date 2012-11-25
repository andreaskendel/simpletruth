<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="imagerow">
	<tiles:importAttribute name="discussions"/>
	<c:forEach var="discussion" items="${discussions}">
		<tiles:insertTemplate template="teaser.jsp">
			<tiles:putAttribute name="discussion" value="${discussion}" />
		</tiles:insertTemplate>
	</c:forEach>
</div>