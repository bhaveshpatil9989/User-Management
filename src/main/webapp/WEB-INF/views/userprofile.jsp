<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Profile</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" />
<link href="/css/simple-sidebar.css" rel="stylesheet" />
<script src="/webjars/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/css/bootstrap-select.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/js/bootstrap-select.js"></script>
		
</head>
<body>
	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="sidebar.jsp" />

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<jsp:include page="header.jsp" />

			<div class="col-md-12">
				<div class="">
					<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<h4>Your Profile</h4>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form>
									<!-- <div class="form-group row">
										<label for="username" class="col-4 col-form-label">User
											Name*</label>
										<div class="col-8">
											<input id="username" name="username" placeholder="Username"
												class="form-control here" required="required" disabled type="text">
										</div>
									</div> -->
									<div class="form-group row">
										<label for="name" class="col-4 col-form-label">First
											Name</label>
										<div class="col-8">
											<input id="name" name="name" value="${user.firstName}"
												placeholder="First Name" class="form-control here" disabled
												type="text">
										</div>
									</div>
									<div class="form-group row">
										<label for="lastname" class="col-4 col-form-label">Last
											Name</label>
										<div class="col-8">
											<input id="lastname" name="lastname" value="${user.lastName}"
												placeholder="Last Name" class="form-control here" disabled
												type="text">
										</div>
									</div>
									<div class="form-group row">
										<label for="select" class="col-4 col-form-label">Role</label>
										<div class="col-8">
											<input id="role" name="role" value="${user.role.roleName}"
												placeholder="Role" class="form-control here" disabled
												required="required" type="text">
											<%-- <select id="select" name="select" class="custom-select">
												<option value="${user.role.roleId}">${user.role.roleName}</option>
											</select> --%>
										</div>
									</div>
									<div class="form-group row">
										<label for="email" class="col-4 col-form-label">Email</label>
										<div class="col-8">
											<input id="email" name="email" value="${user.email}"
												placeholder="Email" class="form-control here" disabled
												required="required" type="text">
										</div>
									</div>
									<div class="form-group row">
										<label for="publicinfo" class="col-4 col-form-label">Address</label>
										<div class="col-8">
											<textarea id="publicinfo" name="publicinfo" cols="40"
												disabled rows="4" class="form-control">${user.address}</textarea>
										</div>
									</div>
									<!-- <div class="form-group row">
										<label for="newpass" class="col-4 col-form-label">New
											Password</label>
										<div class="col-8">
											<input id="newpass" name="newpass" placeholder="New Password"
												class="form-control here" type="text">
										</div>
									</div> -->
									<!-- <div class="form-group row">
										<div class="offset-4 col-8">
											<button name="submit" type="submit" class="btn btn-primary">Update
												My Profile</button>
										</div>
									</div> -->
								</form>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
		<script src="/webjars/popper.js/1.14.1/umd/popper.js"></script>
		<script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="/js/main.js"></script>
	<script type="text/javascript">
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
    </script>
</body>
</html>