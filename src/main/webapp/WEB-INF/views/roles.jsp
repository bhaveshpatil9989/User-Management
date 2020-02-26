<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Roles</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css"/>
 <link href="/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="/chosen/chosen.css">
<link href="/jtable/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<!-- <link href="/jtable/themes/metroblue/jquery-ui.css" rel="stylesheet" type="text/css" /> -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/css/bootstrap-select.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.8.1/js/bootstrap-select.js"></script>

<link href="/webjars/jquery-ui/1.12.1/jquery-ui.css" rel="stylesheet" type="text/css" />
<script src="/webjars/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
<script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js" type="text/javascript"></script>
<script src="/jtable/jquery.jtable.js" type="text/javascript"></script>


</head>
<body>
  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">Start Bootstrap </div>
      <div class="list-group list-group-flush">
        <a href="/dashboard.html" class="list-group-item list-group-item-action bg-light">Dashboard</a>
        <a href="/role" class="list-group-item list-group-item-action bg-light">Shortcuts</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Overview</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Events</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">Profile</a>
        <a href="/logout" class="list-group-item list-group-item-action bg-light">Logout</a>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
        <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <div class="container-fluid">
        <button type="button" id="addRoleBtn" class="btn btn-primary float-right mt-4" data-toggle="modal" data-target="#exampleModal">Add Role</button>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Create Role</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <form id="addRoleForm" action="/role/addRole">
			          <div class="form-group">
			            <label for="recipient-name" class="col-form-label">Role Name:</label>
			            <input type="text" name="roleName" class="form-control" id="roleName">
			          </div>
			          <div class="form-group">
			            <label for="message-text" class="col-form-label">Description:</label>
			            <textarea class="form-control" name="description" id="description"></textarea>
			          </div>
			          <div class="form-group">
			          <label for="message-text" class="col-form-label">Permissions:</label>
						<select  id="permissionsDwn" name="permissions" data-placeholder="Permissions" class="select" multiple tabindex="3">
						<option value=""></option>
						</select>
			          </div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button id="modelSave" type="button" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
		<div id="roleTableContainer"></div>
      </div>
    </div>
    <!-- /#page-content-wrapper -->
	<!-- Modal Code -->
				<div>
  </div>
 

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