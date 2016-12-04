<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>" />
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.smartmenus.js"/>"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link href="<c:url value="/resources/css/sm-core-css.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/sm-blue/sm-blue.css"/>" rel="stylesheet" type="text/css" />
	<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
	<script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>

	<script type="text/javascript">
	var elements= "";
	$(function(){
		var array = elements.split(",");
		$.each(array,function(i){
			 $(array[i]).addClass("borderRed");
		});
	});
	</script>
</head>
<body>
	
	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
	<form:form id="mainform" class="form-inline" role="form" autocomplete="off">
		<tiles:insertAttribute name="header"/>
		<div style="margin-top: 0px;" class="width99">
			<tiles:insertAttribute name="menu" />
		</div>
		<br>
		<div id="message-div" style="max-height: 100px; overflow: auto;max-width:1000px;">
			<c:if test="${!empty errors}">
				<div class="error">
					<ul >
						<c:forEach items="${errors}" var="error">
							<li>${error.name}&nbsp;${error.message} </li>
							<script>
								elements= elements+"#${error.name},";
							</script>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			<c:if test="${!empty success}">
				<div class="success">
					<ul >
						<li>${success}</li>
					</ul>
				</div>
			</c:if>
		</div>
		<div id="maincontent" class="width99">
			<tiles:insertAttribute name="search"/>
			<tiles:insertAttribute name="buttonbar" />
			<tiles:insertAttribute name="body" />
		</div>
		<br>
		<br>
		<div style="position: relative;bottom: 0; display: none;" class="width99" >
			<tiles:insertAttribute name="footer" />
		</div>
	</form:form>
</body>

</html>