<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.dap.search"></spring:message>
<c:url var="searchDap" value="dap"></c:url>
<form:form action="${searchDap}" method="post" commandName="seaarchDap" >

	<table class="table">
		<tr>
			<td><spring:message code="label.dap.dapname" /> </td>
			<td>
				<form:input path="dapName"/> 
			</td>
			<td><spring:message code ="label.dap.chnlcustid"/> </td>
			
			<td><form:select path="channelCustId" cssClass="editabledropdown" >
 				 <form:option value="" label="--Select Please--" />
 				 <form:options items="${customers}" itemValue="id" itemLabel="value" />
 			</form:select></td>
		</tr>
		<tr>
			<td colspan="6" align="right">
				<button type="submit" class="btn btn-primary btn-large center"
					value="Submit"><spring:message code="label.search" /></button>
				<button class="btn btn-primary btn-large center reset" type="reset" 
					onclick=""><spring:message code="label.reset"/></button>
			</td>
		</tr>
	</table>
</form:form>