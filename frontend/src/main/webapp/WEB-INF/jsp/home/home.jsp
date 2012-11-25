<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="path">
	<spring:theme code="content.home.intro" />
</c:set>
<c:set var="url">
	<spring:url value="${path}" />
</c:set>
<img src="${url}" />	