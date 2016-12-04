<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.user.search"></spring:message>

<c:url var="searchCustomer" value="customers"></c:url>
<form:form action="${searchCustomer}" method="post" commandName="searchCustomer" >
	<table class="table">
		<tr>
			<td><spring:message code="label.channelcust.name"/> </td>
			<td>
				<form:input path="channelCustName"/> 
			</td>
		</tr>
	</table>
</form:form>