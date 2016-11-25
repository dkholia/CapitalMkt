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
				<td>
					<a class="editObj" href="<c:url value='/home/group/createeditgroup/${group.groupId}' />" ></a>
					<a class="deleteObj" href="<c:url value='/home/group/remove/${group.groupId}' />" ></a> &nbsp;
					<a  href="<c:url value='/home/fap/details/${fap.fapId}' />" >
					${fap.fapName}</a>
				</td>
				<td>${fap.fapDescription}</td>
				<td>${fap.channel}</td>
				<td>${fap.createdBy}</td>
				<td>${fap.createdDate}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</c:if>