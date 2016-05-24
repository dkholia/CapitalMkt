<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<%@ page session="false"%>


<c:if test="${!empty fapList}">
<spring:message code="label.fap.list"></spring:message> 
 
	<table class="table table-striped table-bordered" id="table1">
	<thead>
		<tr>
			<th>FAP Name</th>
			<th>FAP Description</th>
			<th>Channel</th>
			<th>Created By</th>
			<th>Creation Date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${fapList}" var="fap">
			<tr>
				<%-- <td><a href="<c:url value='/group/${group.groupId}/detail' />" >${group.groupName}</a></td> --%>
				<td>
					<a class="editObj" href="<c:url value='/group/createeditgroup/${group.groupId}' />" ></a>
					<a class="deleteObj" href="<c:url value='/group/remove/${group.groupId}' />" ></a> &nbsp;
					${fap.fapName}
				</td>
				<td>${fap.fapDescription}</td>
				<td>${fap.channel}</td>
				<td>${fap.createdBy}</td>
				<td>${fap.createdDate}</td>
				<%-- <td>
					<a class="editObj" href="<c:url value='/group/createeditgroup/${group.groupId}' />" ></a>
					<a class="deleteObj" href="<c:url value='/group/remove/${group.groupId}' />" ></a>
				</td> --%>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</c:if>