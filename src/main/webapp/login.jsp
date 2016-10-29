<!DOCTYPE HTML>
<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page session="false" %>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="/css/style.css" rel="stylesheet" />
<body
	background="http://www.wallpaperup.com/uploads/wallpapers/2012/10/21/20181/cad2441dd3252cf53f12154412286ba0.jpg">
	<div class="container">
		<div id="message-div">
			
			<c:if test="${!empty errors}">
				<ul >
					<c:forEach items="${errors}" var="error">
						<li style="color: red;">${error.name}  ${error.message}</li>
					</c:forEach>
				</ul>
				
			</c:if>
			
		</div>
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					
					<h3>Connect to Facebook</h3>
  					<form:form action="./connect/facebook" method="POST" sec:authorize="isAnonymous()" >
   						<input type="hidden" name="scope" value="public_profile,email" />
						<input type="hidden" name="_csrf" th:value="${_csrf.token}" />
   							<p><button type="submit">Login With Facebook</button></p>
  					</form:form>
  					
  					<form:form action="./connect/twitter" method="POST">
   						<input type="hidden" name="scope" value="public_profile,email" />
							<input type="hidden" name="_csrf" th:value="${_csrf.token}" />
   							<p><button type="submit">Login With Twitter</button></p>
  					</form:form>
					<form:form id="loginform" class="form-horizontal" role="form" action="./login" method="post" commandName="login">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username">
								<%-- <form:input path="uname"/> --%>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
								<%-- <form:input path="upwd"/> --%>
						</div>



						<div class="input-group" style="display: none;">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox" name="remember" value="1" > Remember me
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<input type="submit" class="btn btn-default" value="<spring:message text="Login"/>" />
								<a id="btn-login" href="#" class="btn btn-success" style="display: none;">Login </a> 
								<a id="btn-fblogin" href="#" class="btn btn-primary" style="display: none;">Login with Facebook</a>
							</div>
						</div>


						<div class="form-group" style="display: none;">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									Don't have an account! <a href="#"
										onClick="$('#loginbox').hide(); $('#signupbox').show()">
										Sign Up Here </a>
								</div>
							</div>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>