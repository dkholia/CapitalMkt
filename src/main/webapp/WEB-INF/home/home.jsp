<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName} value="${_csrf.token}" />
</form>
<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:formSubmit()"> Logout</a>
</c:if>

