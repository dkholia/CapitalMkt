<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.user.${mode}"></spring:message>
  <c:url var="addAction" value="/channeluser/createUser" ></c:url>
 <form:form id="createUser" commandName="user" method="post" action="${addAction}" autocomplete="false" >
 	<table class="table">
 		<tr>
 			<td><spring:message code="label.createuser.userid"></spring:message> </td><td colspan="7"><form:input path="loginid"/> </td>
 		</tr>
 		<tr>
 			<td><spring:message code="label.createuser.fname"></spring:message> </td><td><form:input path="fname"/> </td>
 			<td><spring:message code="label.createuser.mname"></spring:message> </td><td><form:input path="mname"/></td>
 			<td><spring:message code="label.createuser.lname"></spring:message> </td><td><form:input path="lname"/></td>
 			<td><spring:message code="label.createuser.dob"></spring:message> </td><td><form:input path="dob" class="datepicker"/></td>
 		</tr>
 		
 		<tr>
 			<td><spring:message code="label.createuser.address1"></spring:message> </td><td><form:input path="address1"/></td>
 			<td><spring:message code="label.createuser.address2"></spring:message> </td><td><form:input path="address2"/></td>
 			<td><spring:message code="label.createuser.city"></spring:message> </td><td><form:input path="city"/></td>
 			<td><spring:message code="label.createuser.state"></spring:message> </td><td><%-- <form:input path="state"/> --%>
 			
	 			<form:select path="state" >
	 				 <form:option value="" label="--Select Please--" />
	 				 <form:options items="${states}" itemValue="id" itemLabel="value" />
	 			</form:select>
 			</td>
 		</tr>
 		<tr>
 			<td><spring:message code="label.createuser.postalcode"></spring:message> </td><td><form:input path="postalcode"/></td>
 			<td><spring:message code="label.createuser.country"></spring:message> </td><td colspan="5"><%-- <form:select path="country" items="${countries}" itemValue="id" itemLabel="value"  title="select.." ></form:select> --%>
 			
 			<form:select path="country" >
 				 <form:option value="" label="--Select Please--" />
 				 <form:options items="${countries}" itemValue="id" itemLabel="value" />
 			</form:select></td></td>
 		</tr>
 		<tr>
 			<td><spring:message code="label.createuser.contactNumber"></spring:message> </td><td><form:input path="contactNumber"/></td>
 			<td><spring:message code="label.createuser.emailID"></spring:message> </td><td colspan="5"><form:input path="emailID"/></td>
 		</tr>
 		<tr>
 			<td colspan="8"></td>
 		</tr>
 	</table>
 	<div class="panel panel-default" id="panel_groupMapping">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-target="#groupMapping"
					href="#groupMapping" class="collapsed"><spring:message code="label.createuser.attachgroup"/>
				</a>
			</h4>
		</div>
		<div id="groupMapping" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table table-striped table-bordered" style="width: 100%;">
					<thead>
						<tr>
							<th><input type="checkbox" class="selectAll" /> <spring:message code="label.menu.groups.search.groupname"/></th>
							<th><spring:message  code="label.menu.groups.search.groupdesc"/> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allgroups}" var="group">
							<tr>
								<td>
								<form:checkbox path="groups" value="${group.groupId}"/>
								${group.groupName}</td>
								<td>${group.groupdesc}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
 	
 	<div class="panel panel-default" id="panel_fapMapping">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-target="#fapMapping"
					href="#fapMapping" class="collapsed"><spring:message code="label.createuser.attachfap"/>
				</a>
			</h4>
		</div>
		<div id="fapMapping" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table table-striped table-bordered" style="width: 100%;">
					<thead>
						<tr>
							<th> <input type="checkbox" class="selectAll" /> <spring:message code="label.fap.fapname"/></th>
							<th><spring:message  code="label.fap.fapdesc"/> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allfaps}" var="fap">
							<tr>
								<td>
								<form:checkbox path="faps" value="${fap.fapId}"/>
								${fap.fapName}</td>
								<td>${fap.fapDescription}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="panel panel-default" id="panel_dapMapping">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-target="#dapMapping"
					href="#dapMapping" class="collapsed"><spring:message code="label.createuser.attachdap"/>
				</a>
			</h4>
		</div>
		<div id="dapMapping" class="panel-collapse collapse">
			<div class="panel-body">
				<table class="table table-striped table-bordered" style="width: 100%;">
					<thead>
						<tr>
							<th  style="width: 20px;"><input type="checkbox" class="selectAll" /> </th>
							<th><spring:message code="label.dap.dapname"/></th>
							<th><spring:message  code="label.dap.dapdesc"/> </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${alldaps}" var="dap">
							<tr>
								<td><form:checkbox path="daps" value="${dap.dapId}"/></td>
								<td>${dap.dapName}</td>
								<td>${dap.dapDescription}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
		</div>
	</div>
 	
 	
 	<div align="right">
 		<input type="reset" value='<spring:message code="label.reset"></spring:message>'/>
 		<input type="submit" value='<spring:message code="label.submit"></spring:message>'/>
 	</div>
 </form:form>