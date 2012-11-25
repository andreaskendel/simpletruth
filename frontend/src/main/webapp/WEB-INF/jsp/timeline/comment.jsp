<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute name="comment"/>
<div class="comment">
	<div>${comment.createdBy.displayName}</div>
	<div>${comment.text}</div>
</div>