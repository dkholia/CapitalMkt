<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.fap.search"></spring:message>
<c:url var="searchFap" value="fap"></c:url>
<form:form action="${searchFap}" method="post" commandName="searchFap" >
	<table class="table">
		<tr>
			<td><spring:message code="label.fap.fapname" /> </td>
			<td>
				<form:input path="fapName"/> 
			</td>
			<%-- <td><spring:message code="label.fap.fapdesc" /> </td>
			<td>
				<form:input path="fapDescription"/> 
			</td> --%>
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