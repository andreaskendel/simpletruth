<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- include Stylesheet -->
<tiles:importAttribute name="css" />
<c:forEach items="${css}" var="cssName">
	<spring:theme code="${cssName}" var="cssPath" />
	<spring:url value="${cssPath}" var="cssUrl" />
	<link rel="stylesheet" href="${cssUrl}" type="text/css" charset="utf-8" />
</c:forEach>

<!-- include Javascript -->
<tiles:importAttribute name="js" />
<c:forEach items="${js}" var="jsPath">
	<spring:url value="${jsPath}" var="jsUrl" />
	<script src="${jsUrl}" type="text/javascript" charset="utf-8">
		
	</script>
</c:forEach>

<!-- Title -->
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<!-- Body -->
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
