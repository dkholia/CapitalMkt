<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form commandName="dap">
	<spring:message code="label.dap.${mode}"></spring:message>
	<table class="table">
		<tr>
			<td><spring:message code ="label.dap.dapname"/> </td>
			<td><form:input path="dapName"/> </td>
			<td><spring:message code ="label.dap.dapname"/> </td>
			<td><form:input path="dapDescription"/> </td>
			<td><spring:message code ="label.dap.chnlcustid"/> </td>
			
			<td><form:select path="channelCustId" cssClass="editabledropdown" >
 				 <form:option value="" label="--Select Please--" />
 				 <form:options items="${customers}" itemValue="id" itemLabel="value" />
 			</form:select></td>
		</tr>
		<tr>			
			<td colspan="6" align="right">
			<button type="submit" class="btn btn-primary btn-large center" value="Submit" ><spring:message code="label.create"/> </button> 
			<button class="btn btn-primary btn-large center" type="reset"  onclick=""><spring:message code="label.reset"/> </button>
			</td>
		</tr>
	</table>
</form:form>	