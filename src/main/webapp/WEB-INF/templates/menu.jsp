<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<head>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX: 1,
			subMenusSubOffsetY: -8
		});
	});
</script>
</head>


<nav id="main-nav" role="navigation">
	<ul id="main-menu" class="sm sm-blue">
		<li><a href="<c:url value="/home"/>"><spring:message code="label.menu.home"/></a></li>
		<li><a><spring:message code="label.menu.users"/></a>
			<ul id="sub-menu-users">
				<li><a href="<c:url value="/home/channeluser"/>">User List</a></li>
				<li><a href="<c:url value="/home/channeluser/createUser"/>"><spring:message code="label.menu.users.createuser"></spring:message></a></li>
			</ul>
		</li>
		<li><a><spring:message code="label.menu.groups"/></a>
			<ul id="sub-menu-group">
				<li><a href="<c:url value="/home/group"/>">Group List</a></li>
				<li><a href="<c:url value="/home/group/createeditgroup"/>">Create Group</a></li>
				<li><a href="<c:url value="/home/group/createeditgroup"/>">Attach Customers to Group</a></li>				
			</ul>
		</li>
		<li><a><spring:message code="label.menu.customers"/></a>
				<ul id="sub-menu-group">
						<li><a href="<c:url value="/home/customers"/>"><spring:message code="label.channelcust.list"/></a></li>
						<li><a href="<c:url value="/home/createcustomer"/>"><spring:message code="label.channelcust.create"/></a></li>
				</ul>			
		</li>
		<li><a><spring:message code="label.menu.fap"/></a>
			<ul>
				<li><a href="<c:url value="/home/fap"/>"><spring:message code="label.fap.list" /> </a></li>
				<li><a href="<c:url value="/home/createfap"/>"> <spring:message code="label.fap.create"/> </a> </li>
			</ul>
		</li>
		<li><a><spring:message code="label.menu.dap"/></a>
			<ul>
				<li><a href="<c:url value="/home/dap"/>"><spring:message code="label.dap.list" /> </a></li>
				<li><a href="<c:url value="/home/createdap"/>"> <spring:message code="label.dap.create"/> </a> </li>
			</ul>
		</li>
	</ul>
</nav>
