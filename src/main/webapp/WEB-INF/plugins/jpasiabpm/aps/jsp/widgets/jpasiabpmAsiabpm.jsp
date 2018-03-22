<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="wp" uri="/aps-core"%>
<%@ taglib prefix="jpasiabpm" uri="/jpasiabpm-core"%>

<jpasiabpm:asiabpm var="asiabpm" />
<article>
<c:choose>
	<c:when test="${not empty asiabpm}">
	<h1><wp:i18n key="jpasiabpm_ASIABPM_ID" />: <c:out value="${asiabpm.id}" /></h1>
	<ul>
		<li>
			<wp:i18n key="jpasiabpm_ASIABPM_AFIELD" />: <c:out value="${asiabpm.afield}" /><br />
		</li>
	</ul>
	</c:when>
	<c:otherwise>
	<div class="alert alert-error">
		<p><wp:i18n key="jpasiabpm_ASIABPM_NOT_FOUND" /></p>
	</div>
	</c:otherwise>
</c:choose>
</article>