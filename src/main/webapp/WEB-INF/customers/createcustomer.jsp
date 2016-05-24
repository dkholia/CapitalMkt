<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<form:form commandName="customer">
	<spring:message code="label.channelcust.create"/>
	<table class="table">
		<tr>
			<td><spring:message code ="label.channelcust.name"/> </td>
			<td><form:input path="channelCustName"/> </td>
			<td><spring:message code ="label.channelcust.description"/> </td>
			<td><form:input path="channelCustDesc"/> </td>
		</tr>
		<tr>			
			<td colspan="6" align="right">
			<button type="submit" class="btn btn-primary btn-large center" value="Submit" ><spring:message code="label.create"/> </button> 
			<button class="btn btn-primary btn-large center" type="reset"  onclick=""><spring:message code="label.reset"/> </button>
			</td>
		</tr>
	</table>
</form:form>	