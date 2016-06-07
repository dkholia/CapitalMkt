<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${!empty dapList}">
<spring:message code="label.fap.list"></spring:message> 
 
	<table class="table table-striped table-bordered" id="table1">
	<thead>
		<tr>
			<th><spring:message code="label.dap.dapname"/> </th>
			<th><spring:message code="label.dap.dapdesc"/> </th>
			<th><spring:message code="label.dap.chnlcust"/> </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${dapList}" var="dap">
			<tr>
				<td>
					<a class="editObj" href="<c:url value='/group/createeditgroup/${group.groupId}' />" ></a>
					<a class="deleteObj" href="<c:url value='/group/remove/${group.groupId}' />" ></a> &nbsp;
					<a  href="<c:url value='/dap/details/${dap.dapId}' />" >${dap.dapName}</a>
				</td>
				<td>${dap.dapDescription}</td>
				<td>${dap.channelCustId}</td>
				<%-- <td>
					<a class="editObj" href="<c:url value='/group/createeditgroup/${group.groupId}' />" ></a>
					<a class="deleteObj" href="<c:url value='/group/remove/${group.groupId}' />" ></a>
				</td> --%>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</c:if>