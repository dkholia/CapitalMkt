<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<div id="basic-details" class="container-fluid">
	<h4>
		<spring:message code="label.menu.group.groupdetails"></spring:message>
		&nbsp;${groupdetails.groupName}
	</h4>
	<table class="table">
		<tr class="even">
			<td><spring:message code="label.menu.groups.search.groupname"></spring:message>
			</td>
			<td>${groupdetails.groupName}</td>
			<td><spring:message code="label.menu.groups.search.groupdesc"></spring:message>
			</td>
			<td>${groupdetails.groupdesc}</td>
			<td><spring:message
					code="label.menu.groups.search.groupcreateddt"></spring:message></td>
			<td></td>
		</tr>
	</table>
</div>
<div class="panel panel-default" id="panel_custMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#custMapping"
				href="#custMapping" class="collapsed">Linked Channel Customers
			</a>
		</h4>
	</div>
	<div id="custMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty groupdetails.chChannelCustGrpMappings}">
				<table id="table1" class="table table-striped table-bordered"
					style="width: 100%;">
					<thead>
						<tr>
							<th width="120">Customer Name</th>
							<th width="120">Customer Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${groupdetails.chChannelCustGrpMappings}" var="chChannelCustGrpMappings">
							<tr>

								<td><a href="<c:url value='/customers/customerdetails/${chChannelCustGrpMappings.chChannelCustomer.channelCustId}' />"> ${chChannelCustGrpMappings.chChannelCustomer.channelCustName}</a></td>
								<td>${chChannelCustGrpMappings.chChannelCustomer.channelCustDesc}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty groupdetails.chChannelCustGrpMappings}">
				<capmkt:nodatafound></capmkt:nodatafound>
			</c:if>

		</div>
	</div>
</div>
<div class="panel panel-default" id="panel_userMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#userMapping"
				href="#userMapping" class="collapsed">Channel User Group Mappings
			</a>
		</h4>
	</div>
	<div id="userMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty groupdetails.chUserGroupMappings}">
			<table id="table2" class="table table-striped table-bordered"
				style="width: 100%;">
				<thead>
					<tr>
						<th width="120">UserID</th>
						<th>User Name</th>
						<th>Creation Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${groupdetails.chUserGroupMappings}"
						var="chUserGroupMappings">
						<tr>
							<td><a
								href="<c:url value='/channeluser/${chUserGroupMappings.chUser.userid}/details' />">${chUserGroupMappings.chUser.uname}</a></td>
							<td>${chUserGroupMappings.chUser.lasname},${chUserGroupMappings.chUser.firstname}&nbsp;${chUserGroupMappings.chUser.middlename}</td>
							<td>${chUserGroupMappings.chUser.datecreated}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty groupdetails.chUserGroupMappings}">
			<capmkt:nodatafound></capmkt:nodatafound>
		</c:if>
		</div>
	</div>
</div>