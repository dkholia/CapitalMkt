<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/capmkt.tld" prefix="capmkt"%>
<div id="basic-details" class="container-fluid">
	<h4>
		<spring:message code="label.dap.details"></spring:message>
		&nbsp;${dapdetails.dapName}
	</h4>
	<table class="table">
		<tr class="even">
			<td><spring:message code="label.dap.dapname"/>
			</td>
			<td>${dapdetails.dapName}</td>
			<td><spring:message code="label.dap.dapdesc"/>
			</td>
			<td>${dapdetails.dapDescription}</td>
			<td><spring:message code="label.dap.chnlcust"/> </td>
			<td><a href='<c:url value="/customers/customerdetails/${dapdetails.channelCustId}"></c:url>' > <i class="fa fa-user" aria-hidden="true"></i></a></td>
		</tr>
	</table>
</div>

<div class="panel panel-default" id="panel_UserMapping">
	<div class="panel-heading">
		<h4 class="panel-title">
			<a data-toggle="collapse" data-target="#userMapping"
				href="#userMapping" class="collapsed"><spring:message code="label.dap.linkedUsers"/>
			</a>
		</h4>
	</div>
	<div id="userMapping" class="panel-collapse collapse">
		<div class="panel-body">
			<c:if test="${!empty dapdetails.chDapUserMappings}">
				<table id="table1" class="table table-striped table-bordered"
					style="width: 100%;">
					<thead>
						<tr>
							<th ><spring:message code="label.createuser.userid" /> </th>
							<th ><spring:message code="label.user.username" /> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dapdetails.chDapUserMappings}" var="userMappings">
							<tr>
								<td><a href="<c:url value='/channeluser/${userMappings.chUser.userid}/details' />">${userMappings.chUser.uname}</a></td>
								<td>${userMappings.chUser.lasname},${userMappings.chUser.firstname} ${userMappings.chUser.middlename}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty dapdetails.chDapUserMappings}">
				<capmkt:nodatafound></capmkt:nodatafound>
			</c:if>

		</div>
	</div>
</div>