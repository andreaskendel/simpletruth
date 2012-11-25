<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row1}" />
</tiles:insertTemplate>
<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row2}" />
</tiles:insertTemplate>
<tiles:insertTemplate template="row.jsp">
	<tiles:putAttribute name="discussions" value="${row3}" />
</tiles:insertTemplate>