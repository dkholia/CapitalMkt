<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<h2>Hello ${username}, You do not have permission to access this page!</h2>
		</c:otherwise>
	</c:choose>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	Click&nbsp;<a href="${context}" >here</a>&nbsp;to go back to login page 
</body>
</html>