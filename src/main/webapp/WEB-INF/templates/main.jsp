<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css"/>" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.smartmenus.js"/>"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 <script type="text/javascript"
	src="<c:url value="/resources/js/common.js"/>"></script>
<link href="<c:url value="/resources/css/sm-core-css.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/sm-blue/sm-blue.css"/>"
	rel="stylesheet" type="text/css" />
<script
	src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
<!-- <link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css"> -->

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 10,
			subMenusSubOffsetY : -80
		});
		$('.table').css("width","100%");
		$('.table-striped').DataTable( {
			  "lengthMenu": [ [5,10, 25, 50, -1], [5,10, 25, 50, "All"] ]
		});
		
	});
</script>
</head>
<body>
	<form:form id="mainform" class="form-inline" role="form">
		
		<div id="dialog-div"> </div>
		<div id="header" style="display: none;">
			<div id="headerTitle">
				<tiles:insertAttribute name="header" />
			</div>
		</div>
		<div>
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- <div id="content"> -->
		<br>
		<div id="message-div">
			<c:if test="${!empty errors}">
				<div class="error">
					<ul >
						<c:forEach items="${errors}" var="error">
							<li>${error.name}  ${error.message}</li>
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
		<div id="maincontent">
			<tiles:insertAttribute name="body" />
		</div>
		<br>
		<br>
		<div id="footer" style="display: none;">
			<tiles:insertAttribute name="footer" />
		</div>
	</form:form>
</body>

</html>