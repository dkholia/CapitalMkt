<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 500 - Internal Server Error</h1>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	Click&nbsp;<a href="${context}/home" >here</a>&nbsp;to go back to home page 
</body>
</html>