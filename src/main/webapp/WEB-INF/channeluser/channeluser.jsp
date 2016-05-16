<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<spring:message code="label.user.list"></spring:message>
<c:if test="${!empty userList}">
	<table  class="table table-striped table-bordered" id="usersTable">
		<thead>
			<tr>
			<th width="120" draggable="true" >User Name</th>
			<th width="120" draggable="true">Status</th>
			<th width="60" draggable="true">Date Created</th>
			<th width="60"></th>
			</tr> 
		</thead>
		<tbody>
			<c:forEach items="${userList}" var ="user">
				<tr>
					<td class="contextMenu"><a href="<c:url value='/channeluser/${user.userid}/details/' />" >${user.lasname}, ${user.firstname} ${user.middlename}</a></td>
					<td>${user.isactive}</td>
					<td>${user.datecreated}</td>
					<td><a href="<c:url value='/channeluser/${user.userid}/editUser' />" >edit</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
	<!-- Context Menu Start-->
	<ul id="contextMenu" class="dropdown-menu" role="menu" style="display:none" >
	    <li><a tabindex="-1" href= "<c:url value='/group/55/detail' />">Action</a></li>
	    <li><a tabindex="-1" href="#">Another action</a></li>
	    <li><a tabindex="-1" href="#">Something else here</a></li>
	    <li class="divider"></li>
	    <li><a tabindex="-1" href="#">Separated link</a></li>
	</ul>
	<!-- Context Menu End  -->
</c:if>