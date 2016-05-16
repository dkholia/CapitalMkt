<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<spring:message code="label.user.${mode}"></spring:message>
<!--  
 <div class="panel panel-default" id="panel2">
        <div class="panel-heading">
             <h4 class="panel-title">
        <a data-toggle="collapse" data-target="#collapseTwo" 
           href="#collapseTwo" class="collapsed">
          Collapsible Group Item #2
        </a>
      </h4>

        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
            <div class="panel-body">Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</div>
        </div>
    </div>
    
    -->
  <c:url var="addAction" value="/channeluser/createUser" ></c:url>
 <form:form id="createUser" commandName="user" method="post" action="${addAction}" autocomplete="false" >
 	<table class="table">
 		<tr>
 			<td><spring:message code="label.createuser.userid"></spring:message> </td><td><form:input path="loginid"/> </td><td/><td/><td/><td/><td/><td/>
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
 	<div align="right">
 		<input type="reset" value='<spring:message code="label.reset"></spring:message>'/>
 		<input type="submit" value='<spring:message code="label.submit"></spring:message>'/>
 	</div>
 </form:form>