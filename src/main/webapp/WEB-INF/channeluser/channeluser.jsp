<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${!empty userList}">
	<spring:message code="label.user.list"></spring:message>
	
	<table  class="table table-striped table-bordered" id="usersTable">
		<thead>
			<tr>
			<th width="120" draggable="true" >User ID</th>
			<th>User Name</th>
			<th width="120" draggable="true">Status</th>
			<th width="60" draggable="true">Date Created</th>
			<th width="60"></th>
			</tr> 
		</thead>
		<tbody>
			<c:forEach items="${userList}" var ="user">
				<c:if test="${user.usertyp eq 'nonadmin'}">
				<tr>
					<td ><a oncontextmenu="alert('hi');" contextmenu="menu"  href="<c:url value='/home/channeluser/${user.userid}/details/' />" >${user.uname} </a></td>
					<td>${user.lasname}, ${user.firstname} ${user.middlename}</td>
					<td>${user.isactive}</td>
					<td>${user.datecreated}</td>
					<td><a  class="editObj" href="<c:url value='/home/channeluser/${user.userid}/editUser' />" ></a>
					<a class="deleteObj" href="<c:url value='/home/channeluser/${user.userid}/deleteUser' />" ></a></td>
				</tr>
				</c:if>
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