<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navipart">
	<div class="mainnavi">
		<tiles:importAttribute name="url" ignore="true" />
		<c:choose>
			<c:when test="${not empty url}">
				<spring:url value="${url}" var="path" />
				<a class="navilink" href="${path}"><tiles:insertAttribute
						name="name" /></a>
			</c:when>
			<c:otherwise>
				<a class="navilink"><tiles:insertAttribute name="name" /></a>
			</c:otherwise>
		</c:choose>
	</div>
	<tiles:insertAttribute name="subnavi" defaultValue="" />
</div>