<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="url" value="/home" />
	<tiles:putAttribute name="name" value="Simple Truths" />
	<tiles:putAttribute name="subnavi">
		<tiles:insertTemplate template="comments.jsp"
			preparer="topCommentsPreparer" />
	</tiles:putAttribute>
</tiles:insertTemplate>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="url" value="/imageboard" />
	<tiles:putAttribute name="name" value="Imageboard" />
</tiles:insertTemplate>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="url" value="/timeline" />
	<tiles:putAttribute name="name" value="Timeline" />
</tiles:insertTemplate>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="url" value="/about" />
	<tiles:putAttribute name="name" value="About" />
</tiles:insertTemplate>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="name" value="Contact" />
	<tiles:putAttribute name="subnavi">
		<tiles:insertTemplate template="contact.jsp" />
	</tiles:putAttribute>
</tiles:insertTemplate>

<tiles:insertTemplate template="entry.jsp">
	<tiles:putAttribute name="name" value="Login" />
	<tiles:putAttribute name="subnavi">
		<tiles:insertTemplate template="login.jsp" />
	</tiles:putAttribute>
</tiles:insertTemplate>
