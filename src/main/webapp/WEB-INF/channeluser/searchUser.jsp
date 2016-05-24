<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.user.search"></spring:message>

<c:url var="searchUser" value="channeluser"></c:url>
<form:form method="post" action="${searchUser}" commandName="searchUser" >
	<table class="table">
		<tr>
			<td><spring:message code="label.createuser.userid"></spring:message> </td>
			<td>
				<form:input path="loginid"/> 
			</td>
			<td><spring:message code="label.createuser.fname"></spring:message></td>
			<td>
				<form:input path="fname"/> 
			</td>
			<td><spring:message code="label.createuser.dob"></spring:message></td>
			<td>
				<form:input path="dob" class="datepicker"/>
			</td>
		</tr>
		<tr>
			<td colspan="6" align="right">
				<button type="submit" class="btn btn-primary btn-large center"
					value="Submit"><spring:message code="label.search" /></button>
				<button class="btn btn-primary btn-large center" type="reset"
					onclick=""><spring:message code="label.reset"/></button>
			</td>
		</tr>
	</table>
</form:form>