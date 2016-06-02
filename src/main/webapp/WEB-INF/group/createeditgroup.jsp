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
	<hr>
	<table class="table">
		
		<tr>
			<c:if test="${!empty group.groupId}">
				<td><label>Group ID</label></td>
				<td><form:input path="groupId" readonly="true"/></td>
			</c:if>
			<td><label>Group Name</label></td>
			<td><form:input path="groupName"/></td>
			<td><label>Group Description</label></td>
			<td><form:input path="groupDesc"/></td>
		</tr>
		
	</table>
	<c:if test="${mode eq 'create'}">
		All Customers
		<table class="table table-striped table-bordered display">
			<thead>
			<tr>
				<th>Option</th>
				<th>Customer Name</th>	
				<th>Customer Description</th>	
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allCustomers}" var="customer">
				<tr>
					<%-- <c:if test="${customer.selected eq true}">
						<td><input type="checkbox" checked="checked"> </td>
					</c:if>
					<c:if test="${customer.selected eq false}">
						<td><input type="checkbox"> </td>
					</c:if> --%>
					<td>
					<form:checkbox path="customers" value="${customer.channelCustId}"/></td>
					<td>${customer.channelCustName}</td>
					<td>${customer.channelCustDesc}</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<table>
			<tr>			
			<td colspan="6" align="right">
			<button type="submit" class="btn btn-primary btn-large center" value="Submit" >Submit</button> 
			<button class="btn btn-primary btn-large center" type="reset"  onclick="">
                        Reset
			</button>
			</td>
		</tr>
		</table>
	</c:if>
	</form:form>
</html>
