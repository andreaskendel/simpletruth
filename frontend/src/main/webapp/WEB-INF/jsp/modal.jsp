<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute name="title"/>
<div id="modal" title="${title}">
	<div class="content">
		<tiles:insertAttribute name="content" />
	</div>
</div>