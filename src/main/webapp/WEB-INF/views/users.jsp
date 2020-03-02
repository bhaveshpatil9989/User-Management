<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>User</title>
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

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<jsp:include page="header.jsp" />
			
			<div class="card-body">
			<div class="row">
							<div class="col-md-12">
								<h4>Manage Users</h4>
								<hr>
							</div>
						</div>
			<div id="userTableContainer"></div>
			</div>
		</div>
	</div>
	
		<script src="/webjars/popper.js/1.14.1/umd/popper.js"></script>
	<script src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script src="/chosen/chosen.jquery.js" type="text/javascript"></script>
	<script src="/js/main.js"></script>
	 <script src="/js/users.js"></script>
	<script src="/js/jquery.serializeToJSON.js"></script>
	<script type="text/javascript">
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
    </script>
</body>
</html>