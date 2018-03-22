<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>

<wp:ifauthorized permission="superuser">
	<li><a href="<s:url namespace="/do/jpasiabpm/Asiabpm" action="list" />" ><s:text name="jpasiabpm.title.asiabpmManagement" /></a></li>
</wp:ifauthorized>
