<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Manage Roles</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" />
<link href="/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="/chosen/chosen.css">
<link href="/jtable/themes/metro/blue/jtable.css" rel="stylesheet"
	type="text/css" />
<!-- <link href="/jtable/themes/metroblue/jquery-ui.css" rel="stylesheet" type="text/css" /> -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/css/bootstrap-select.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/js/bootstrap-select.js"></script>

<link href="/webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script src="/webjars/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="/jtable/jquery.jtable.js" type="text/javascript"></script>


</head>
<body>
	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="sidebar.jsp" />
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
		
		<jsp:include page="header.jsp" />

<!-- 			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-primary" id="menu-toggle">Toggle
					Menu</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dropdown </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
					</ul>
				</div>
			</nav> -->
			<div class="card-body">
			<div class="row">
							<div class="col-md-12">
								<h4>Manage Roles</h4>
								<hr>
							</div>
						</div>
			<div id="roleTableContainer"></div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
	<!-- Modal Code -->
	<div></div>


	<script src="/webjars/popper.js/1.14.1/umd/popper.js"></script>
	<script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="/chosen/chosen.jquery.js" type="text/javascript"></script>
	<script src="/js/main.js"></script>
	<script src="/js/role.js"></script>
	<script src="/js/jquery.serializeToJSON.js"></script>


	<!-- Menu Toggle Script -->
	<script type="text/javascript">
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
    /*  $(".select").chosen({width: "100%"});  */
    </script>
</body>
</html>