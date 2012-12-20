<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<spring:url value="/timeline/new" var="url"/>
	<a href="${url}">new</a>
</sec:authorize>
	
	
<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row1}" />
</tiles:insertTemplate>
<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row2}" />
</tiles:insertTemplate>
<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row3}" />
</tiles:insertTemplate>