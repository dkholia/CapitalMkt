<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<li><a href="<c:url value="/home"/>"><spring:message code="label.menu.home"/></a>
			<!-- <ul class="mega-menu">
				<li>
					<div style="width:400px;max-width:100%;">
            			<div style="padding:5px 24px;">
							for more details visit our website <a href="http://www.google.com">Google</a>            				
  	 					 </div>
  					</div>
				</li>
			</ul> -->
		</li>
		<li><a><spring:message code="label.menu.users"/></a>
			<ul id="sub-menu-users">
				<li><a href="<c:url value="/channeluser"/>">User List</a></li>
				<li><a href="<c:url value="/channeluser/createUser"/>"><spring:message code="label.menu.users.createuser"></spring:message></a></li>
			</ul>
		</li>
		<li><a><spring:message code="label.menu.groups"/></a>
			<ul id="sub-menu-group">
				<li><a href="<c:url value="/group"/>">Group List</a></li>
				<li><a href="<c:url value="/group/createeditgroup"/>">Create Group</a></li>
				<li><a href="<c:url value="/group/createeditgroup"/>">Attach Customers to Group</a></li>
			</ul>
		</li>
		<li><a><spring:message code="label.menu.customers"/></a>
				<ul id="sub-menu-group">
						<li><a href="<c:url value="/customers"/>"><spring:message code="label.channelcust.list"/></a></li>
						<li><a href="<c:url value="/createcustomer"/>"><spring:message code="label.channelcust.create"/></a></li>
				</ul>			
		</li>
		<li><a><spring:message code="label.menu.fap"/></a>
			<ul>
				<li><a href="<c:url value="/fap"/>"><spring:message code="label.fap.list" /> </a></li>
				<li><a href="<c:url value="/createfap"/>"> <spring:message code="label.fap.create"/> </a> </li>
			</ul>
		</li>
		<li><a><spring:message code="label.menu.dap"/></a>
			<ul>
				<li><a href="<c:url value="/dap"/>"><spring:message code="label.dap.list" /> </a></li>
				<li><a href="<c:url value="/createdap"/>"> <spring:message code="label.dap.create"/> </a> </li>
			</ul>
		</li>
	</ul>
</nav>
