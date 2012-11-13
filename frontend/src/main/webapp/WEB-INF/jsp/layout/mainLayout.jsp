<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" href="<spring:theme code="stylesheet"/>"
	type="text/css" charset="utf-8" />

<script src="<spring:theme code="jsLibrary"/>" type="text/javascript"
	charset="utf-8">
	
</script>

<script src="<spring:theme 
		code="jsSimtru"/>" type="text/javascript"
	charset="utf-8">
	
</script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div id="page">
		<tiles:insertAttribute name="navigation" />
		<tiles:insertAttribute name="content" />
	</div>
</body>
</html>
