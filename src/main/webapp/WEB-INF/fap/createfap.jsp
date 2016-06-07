<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form commandName="fap">
	<spring:message code="label.fap.${mode}"></spring:message>
	<table class="table">
		<tr>
			<td><spring:message code ="label.fap.fapname"/> </td>
			<td><form:input path="fapName"/> </td>
			<td><spring:message code ="label.fap.fapdesc"/> </td>
			<td><form:input path="fapDescription"/> </td>
			
		</tr>
		<tr>
			<td>
				<form:select  multiple="multiple" path="servicesassoc" items="${services}" itemLabel="value" itemValue="id"/>
			</td>
			<td>
				<table>
					<tr><td>
					<a href='<c:url value="/moveright"></c:url>' >></a>
					</td>
					</tr>
					<tr><td>
					<a href="" >>></a>
					</td></tr>
					<tr><td>
					<a href="" ><</a>
					</td></tr>
					<tr><td>
					<a href="" ><<</a>
					</td></tr>
				</table>
			</td>
			<td>
				<form:select  multiple="multiple" path="linkedServices" />
			</td>
		</tr>
		<tr>			
			<td colspan="6" align="right">
			<button type="submit" class="btn btn-primary btn-large center" value="Submit" ><spring:message code="label.create"/> </button> 
			<button class="btn btn-primary btn-large center" type="reset"  onclick=""><spring:message code="label.reset"/> </button>
			</td>
		</tr>
	</table>
</form:form>	