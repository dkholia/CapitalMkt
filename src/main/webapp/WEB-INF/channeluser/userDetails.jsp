<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<%@ page session="false"%>


<div id="basic-details" class="container-fluid">
	<h4>
		<spring:message code="label.menu.users.userdetails"></spring:message>
		&nbsp;${userDetails.firstname}
	</h4>
	<table class="table">
		<tr>
			<td class="formfield"><spring:message code="label.user.username"></spring:message>
			</td>
			<td class="formfield">${userDetails.lasname},
				${userDetails.firstname} ${userDetails.middlename}</td>
			<td class="formfield"><spring:message code="label.user.isactive"></spring:message>
			</td>
			<td class="formfield">${userDetails.isactive}</td>
			<td class="formfield"><spring:message
					code="label.user.datecreated"></spring:message></td>
			<td class="formfield">${userDetails.datecreated}</td>
		</tr>
	</table>
</div>
<div class="panel panel-default" id="panel_groupMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#groupMapping"
				href="#groupMapping" class="collapsed">Groups </a>
		</h4>
	</div>
	<div id="groupMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty userDetails.chUserGroupMappings}">
				<table class="table table-striped table-bordered "
					style="width: 100%">
					<thead>
						<tr>
							<th>Group Name</th>
							<th>Group Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userDetails.chUserGroupMappings}"
							var="usergroupMap">
							<tr>
								<td><a href="<c:url value='/group/${usergroupMap.chGroup.groupId}/detail' />">${usergroupMap.chGroup.groupName }</a></td>
								<td>${usergroupMap.chGroup.groupdesc }</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					</tfoot>
				</table>
			</c:if>
			<c:if test="${empty userDetails.chUserGroupMappings}">
				<capmkt:nodatafound />
			</c:if>
		</div>
	</div>
</div>

<div class="panel panel-default" id="panel_fapMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#fapMapping"
				href="#fapMapping" class="collapsed">Associated Service Access </a>
		</h4>
	</div>
	<div id="fapMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty userDetails.chFapUserMappings}">
			<table class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>Fap Name</th>
						<th>Fap Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userDetails.chFapUserMappings}"
						var="userfapMap">
						<tr>
							<td><a href="<c:url value='/fap/details/${userfapMap.chFap.fapId}' />">${userfapMap.chFap.fapName }</a></td>
							<td>${userfapMap.chFap.fapDescription }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</c:if>
		<c:if test="${empty userDetails.chFapUserMappings}">
			<capmkt:nodatafound />
		</c:if>
		</div>
	</div>
</div>

<div class="panel panel-default" id="panel_dapMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#dapMapping"
				href="#dapMapping" class="collapsed">Associated Data Access </a>
		</h4>
	</div>
	<div id="dapMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty userDetails.chDapUserMappings}">
			<table class="table table-striped table-bordered" >
				<thead>
					<tr>
						<th>Data Access Name</th>
						<th>Data Access Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userDetails.chDapUserMappings}"
						var="userdapMap">
						<tr>
							<td><a href="<c:url value='/dap/details/${userdapMap.chDap.dapId}' />">${userdapMap.chDap.dapName }</a></td>
							<td>${userdapMap.chDap.dapDescription }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
				</tfoot>
			</table>
		</c:if>
		<c:if test="${empty userDetails.chDapUserMappings}">
			<capmkt:nodatafound />
		</c:if>
		</div>
	</div>
</div>