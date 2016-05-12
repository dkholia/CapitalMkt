<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:message code="label.customer.list"></spring:message>
<c:if test="${!empty listCustomers}">
	<table  class="table table-striped table-bordered" >
		<thead>
			<tr>
			<th width="120" draggable="true" >Channel Customer ID</th>
			<th width="120" draggable="true">Channel Customer Name</th>
			<th width="60" draggable="true">Channel Customer Description</th>
			<th width="60"></th>
			</tr> 
		</thead>
		<tbody>
			<c:forEach items="${listCustomers}" var ="customer">
				<tr>
					<td><a>${customer.channelCustId}</a></td>
					<td>${customer.channelCustName}</td>
					<td>${customer.channelCustDesc}</td>
					<td><a href="<c:url value='/channeluser/${customer.channelCustId}/editUser' />" >edit</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</c:if>