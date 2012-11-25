<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<tiles:importAttribute name="css"/>
<c:forEach items="${css}" var="cssName">
	<c:set var="cssPath">
		<spring:theme code="${cssName}" />
	</c:set>
	<c:set var="cssUrl">
		<spring:url value="${cssPath}" />
	</c:set>
	<link rel="stylesheet" href="${cssUrl}" type="text/css" charset="utf-8" />
</c:forEach>

<tiles:importAttribute name="js"/>
<c:forEach items="${js}" var="jsName">
	<c:set var="jsPath">
		<spring:theme code="${jsName}" />
	</c:set>
	<c:set var="jsUrl">
		<spring:url value="${jsPath}" />
	</c:set>
	<script src="${jsUrl}" type="text/javascript" charset="utf-8">
	</script>
</c:forEach>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div id="page">
		<div id="topnavi">
			<tiles:insertAttribute name="navigation" />
		</div>

		<div id="pageContent">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
</body>
</html>
