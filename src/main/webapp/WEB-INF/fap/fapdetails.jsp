<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<div id="basic-details" class="container-fluid">
	<h4>
		<spring:message code="label.fap.details"></spring:message>
		&nbsp;${fapdetails.fapName}
	</h4>
	<table class="table">
		<tr class="even">
			<td><spring:message code="label.fap.fapname"></spring:message>
			</td>
			<td>${fapdetails.fapName}</td>
			<td><spring:message code="label.fap.fapdesc"></spring:message>
			</td>
			<td>${fapdetails.fapDescription}</td>
			<td></td>
		</tr>
	</table>
</div>
<div class="panel panel-default" id="panel_ServiceMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#serviceMapping"
				href="#serviceMapping" class="collapsed"><spring:message code="label.fap.linkedServices"/>
			</a>
		</h4>
	</div>
	<div id="serviceMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty fapdetails.chServiceDetailses}">
				<table id="table1" class="table table-striped table-bordered"
					style="width: 100%;">
					<thead>
						<tr>
							<th width="120"><spring:message code="label.fap.fapdesc" /> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fapdetails.chServiceDetailses}" var="serviceMappings">
							<tr>
								<td>${serviceMappings.description}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty fapdetails.chServiceDetailses}">
				<capmkt:nodatafound></capmkt:nodatafound>
			</c:if>

		</div>
	</div>
</div>

<div class="panel panel-default" id="panel_UserMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#userMapping"
				href="#userMapping" class="collapsed"><spring:message code="label.fap.linkedUsers"/>
			</a>
		</h4>
	</div>
	<div id="userMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty fapdetails.chFapUserMappings}">
				<table id="table1" class="table table-striped table-bordered"
					style="width: 100%;">
					<thead>
						<tr>
							<th ><spring:message code="label.createuser.userid" /> </th>
							<th ><spring:message code="label.user.username" /> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fapdetails.chFapUserMappings}" var="userMappings">
							<tr>
								<td><a href="<c:url value='/home/channeluser/${userMappings.chUser.userid}/details' />">${userMappings.chUser.uname}</a></td>
								<td>${userMappings.chUser.lasname},${userMappings.chUser.firstname} ${userMappings.chUser.middlename}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty fapdetails.chFapUserMappings}">
				<capmkt:nodatafound></capmkt:nodatafound>
			</c:if>

		</div>
	</div>
</div>