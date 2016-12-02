<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.user.search"></spring:message>

<c:url var="searchUser" value="channeluser"></c:url>
<form:form method="post" action="${searchUser}" commandName="searchUser" >
	<table class="table">
		<tr>
			<td><spring:message code="label.createuser.userid"/> </td>
			<td>
				<form:input path="loginid"/> 
			</td>
			<td><spring:message code="label.user.username"/></td>
			<td>
				<form:input path="fname"/> 
			</td>
			<td><spring:message code="label.createuser.dob"/></td>
			<td>
				<form:input path="dob" class="datepicker"/>
			</td>
		</tr>
	</table>
</form:form>