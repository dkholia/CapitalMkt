<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<%@ page session="false"%>
<div id="basic-details" class="container-fluid">
	<h4>
		<spring:message code="label.channelcust.details"/>
		&nbsp;${custdetails.channelCustName}
	</h4>
	<table class="table">
		<tr>
			<td class="formfield"><spring:message code="label.channelcust.name"/>
			</td>
			<td class="formfield">${custdetails.channelCustName}</td>
			<td class="formfield"><spring:message code="label.channelcust.description"/>
			</td>
			<td class="formfield">${custdetails.channelCustDesc}</td>
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
			<c:if test="${!empty custdetails.chGroups}">
				<table class="table table-striped table-bordered "
					style="width: 100%">
					<thead>
						<tr>
							<th><spring:message code="label.menu.groups.search.groupname"/> </th>
							<th><spring:message code="label.menu.groups.search.groupdesc"/> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${custdetails.chGroups}"
							var="group">
							<tr>
								<td><a href="<c:url value='/group/${group.groupId}/detail' />">${group.groupName }</a></td>
								<td>${group.groupdesc }</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
					</tfoot>
				</table>
			</c:if>
			<c:if test="${empty custdetails.chGroups}">
				<capmkt:nodatafound />
			</c:if>
		</div>
	</div>
</div>