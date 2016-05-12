<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<%@ page session="false"%>

<h3><spring:message code="label.fap.list"></spring:message>  </h3> <a id="createGroup" href="<c:url value='/group/createeditgroup' />"><spring:message code="label.fap.create"/> </a>
<c:if test="${!empty fapList}">
	<table class="table table-striped table-bordered" id="table1">
	<thead>
		<tr>
			<th>FAP Name</th>
			<th>FAP Description</th>
			<th>Channel</th>
			<th>Created By</th>
			<th>Creation Date</th>
			<th >Edit</th>
			<th >Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${fapList}" var="fap">
			<tr>
				<%-- <td><a href="<c:url value='/group/${group.groupId}/detail' />" >${group.groupName}</a></td> --%>
				<td>${fap.fapName}</td>
				<td>${fap.fapDescription}</td>
				<td>${fap.channel}</td>
				<td>${fap.createdBy}</td>
				<td>${fap.createdDate}</td>
				<td><a href="<c:url value='/group/createeditgroup/${group.groupId}' />" >Edit</a></td>
				<td><a href="<c:url value='/group/remove/${group.groupId}' />" >Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</c:if>