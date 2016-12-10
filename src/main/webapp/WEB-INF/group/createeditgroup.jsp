<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<form:form commandName="group">
	<c:if test="${mode eq 'create'}">
		<spring:message code="label.group.create"></spring:message>
	</c:if>
	<c:if test="${mode eq 'edit'}">
		<spring:message code="label.group.edit"></spring:message>
	</c:if>
	<table class="table">
		<tr>
			<%-- <c:if test="${!empty group.groupId}">
				<td><label>Group ID</label></td>
				<td><form:input path="groupId" readonly/></td>
			</c:if> --%>
			<td><label>Group Name</label></td>
			<td><form:input path="groupName"/></td>
			<td><label>Group Description</label></td>
			<td><form:input path="groupDesc"/></td>
		</tr>
		
	</table>
	<%-- <c:if test="${mode eq 'create'}"> --%>
		All Customers
		<table class="table table-striped table-bordered display">
			<thead>
			<tr>
				<th><input type="checkbox" class="selectAll" /> Option</th>
				<th>Customer Name</th>	
				<th>Customer Description</th>	
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allCustomers}" var="customer">
				<tr>
					<td>
					<c:if test="${mode eq 'edit'}">
						<c:if test="${customer.selected eq true}">
							<form:checkbox path="customers" value="${customer.channelCustId}" checked="checked" /></td>
						</c:if>
						<c:if test="${customer.selected eq false}">
							<form:checkbox path="customers" value="${customer.channelCustId}"  /></td>
						</c:if>
					</c:if>
					<c:if test="${mode eq 'create'}">
						<form:checkbox path="customers" value="${customer.channelCustId}" /></td>
					</c:if>
					<td>${customer.channelCustName}</td>
					<td>${customer.channelCustDesc}</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div align="right">
 			<input type="submit" class="btn btn-primary btn-large center" onclick="javascript:showWaitScreen('createUser');" value='<spring:message code="label.submit"></spring:message>'/>
 			<input type="reset"  class="btn  btn-large center" value='<spring:message code="label.reset"></spring:message>'/>
 		</div>
	<%-- </c:if> --%>
	</form:form>
</html>
