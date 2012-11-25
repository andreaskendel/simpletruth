<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div>form</div>
<tiles:importAttribute name="comment" scope="request"/>
<form:form method="post" action="timeline/create" modelAttribute="comment">
	<form:input path="text" />
	<input type="submit" value="Add Contact"/>
</form:form>