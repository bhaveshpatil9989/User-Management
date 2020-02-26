<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script> 
	
	<!-- Latest compiled and minified CSS -->

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

Optional theme
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

Latest compiled and minified JavaScript
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row"><!-- style="color:red; font-weight: bold; margin: 30px 0px;" -->
			  <c:if test="${not empty errorMessge}"><div class="alert alert-danger"  style="font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
			  <c:if test="${not empty successMessge}"><div class="alert alert-success"  style="font-weight: bold; margin: 30px 0px;">${successMessge}</div></c:if>
				<div style="color: red; font-weight: bold; margin: 30px 0px;">
					<div class="span12">
						<div class="" id="loginModal">
							<div class="modal-header" style="border-bottom: 0px solid #eee;">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h3>Have an Account?</h3>
							</div>
							<div class="">
								<div class="well">
									<ul class="nav nav-tabs">
										<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
										<li><a href="#create" data-toggle="tab">Create
												Account</a></li>
									</ul>
									<div id="myTabContent" class="tab-content">
										<div class="tab-pane active in" id="login">
											<form class="form-horizontal" action='/perform_login'
												method="POST">
												<fieldset>
													<div id="legend">
														<legend class="">Login</legend>
													</div>
													<div class="control-group">
														<!-- Username -->
														<label class="control-label" for="username">Username</label>
														<div class="controls">
															<input type="text" id="username" name="username"
																placeholder="" class="input-xlarge">
														</div>
													</div>

													<div class="control-group">
														<!-- Password-->
														<label class="control-label" for="password">Password</label>
														<div class="controls">
															<input type="password" id="password" name="password"
																placeholder="" class="input-xlarge">
														</div>
													</div>
													<input type="hidden" name="${_csrf.parameterName}"
														value="${_csrf.token}" />

													<div class="control-group">
														<!-- Button -->
														<div class="controls">
															<input type="submit" class="btn btn-success" />
														</div>
													</div>
												</fieldset>
											</form>
										</div>
										<div class="tab-pane fade" id="create">
											<form:form method="post" action="/addUser.htm" modelAttribute="user" id="tab">
												<label>Username</label> <form:input path="username" type="text" value="" class="input-xlarge"/> 
												<label>Password</label> <form:input path="password" type="password" value="" class="input-xlarge"/> 
												<label>First Name</label> <form:input path="firstName" type="text" value="" class="input-xlarge"/> 
												<label>Last Name</label> <form:input path= "lastName" type="text" value="" class="input-xlarge"/>
												<label>Email</label> <form:input path="email" type="text" value="" class="input-xlarge"/>
												<label>Address</label> <form:textarea path="address" value="Smith" rows="3" class="input-xlarge"/> 
												<div>
													<input type="submit" class="btn btn-primary" value="Create Account"/>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
</body>
</html>