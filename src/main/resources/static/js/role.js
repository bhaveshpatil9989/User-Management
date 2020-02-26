
var permissionArr = [];
$(document).ready(function() {

$(".select").chosen({
	width : "100%"
});

$('#exampleModal').on('hidden.bs.modal', function(e) {
	permissionArr.splice(0, permissionArr.length);
});

$('#permissionsDwn').on('change', function(evt, params) {
    console.log('Change event '+params)
    permissionArr.push({'permissionId': params.selected});  
});

$('#addRoleBtn').on('click',
		function(e) {
			$.ajax({
				type : 'GET',
				url : '/permission',
				success : function(data) {
					var str = "";
					for (var i = 0; i < data.length; i++) {
						str += "<option value='" + data[i]["permissionId"]
								+ "'>" + data[i]["permissionName"]
								+ "</option>";
					}
					$("#permissionsDwn").empty();
					$("#permissionsDwn").append(str);
					$('#permissionsDwn').val('').trigger('chosen:updated');
				},
				error : function(msg) {
					alert('error :'+ msg);
				}
			});
		});

	$('#modelSave').on("click", function(e) {
		var rolejson = {
			"roleName" : $("#roleName").val(),
			"description" : $("#description").val(),
			"permissions" : permissionArr
		};
		console.log(JSON.stringify(rolejson));
		$.ajax({
			type : 'POST',
			url : '/role/addRole',
			headers : {
				'_csrf' : $("meta[name='_csrf']").attr("content"),
				'_csrf_header' : $("meta[name='_csrf_header']").attr("conten")
			},
			dataType : 'json',
			contentType: 'application/json',
			data : JSON.stringify(rolejson),
			beforeSend : function(x) {
				if (x && x.overrideMimeType) {
					x.overrideMimeType("application/json");
				}
			},
			success : function(data) {
				var str = "";
			},
			error : function(msg) {
				alert('error : ' + msg);
			}
		})
	});
	
	        $('#roleTableContainer').jtable({
	            title: 'The Role List',
	            paging: true, //Enable paging
	            pageSize: 10, //Set page size (default: 10)
	            sorting: true, //Enable sorting
	            defaultSorting: 'Name ASC', //Set default sorting
	            actions: {
	                listAction: '/role/roleList',
	                deleteAction: '/role/DeleteRole',
	                updateAction: '/role/UpdateRole',
	                createAction: '/role/addRole'
	            },
	            fields: {
				roleId : {
							key : true,
							create : false,
							edit : false,
							list : false
						},
						roleName : {
							title : 'Name',
							width : '23%'
						},
						description :
						{
							title : 'Description',
							width :'23%',
							type: 'textarea'
						},
						permissionId: {
							inputClass : 'selectpicker',
		                    title: 'Permissions',
		                    type: 'multiselectddl',
		                    list: true,
		                    options: function(data) {
		                        if (data.source == 'list') {
		                            //Return url all options for optimization. 
		                            return '/permission/rolePermissionsForRole?roleId=28';
		                        }
		                        //This code runs when user opens edit/create form to create combobox.
		                        //data.source == 'edit' || data.source == 'create'
		                        return '/permission/rolePermissions';
		                    }
						//'/permission/rolePermissions'
		                }
	            	
// StudentId: {
// key: true,
// create: false,
//	                    edit: false,
//	                    list: false
//	                },
//	                Name: {
//	                    title: 'Name',
//	                    width: '23%'
//	                },
//	                EmailAddress: {
//	                    title: 'Email address',
//	                    list: false
//	                },
//	                Password: {
//	                    title: 'User Password',
//	                    type: 'password',
//	                    list: false
//	                },
//	                Gender: {
//	                    title: 'Gender',
//	                    width: '13%',
//	                    options: { 'M': 'Male', 'F': 'Female' }
//	                },
//	                CityId: {
//	                    title: 'City',
//	                    width: '12%',
//	                    options: '/Demo/GetCityOptions'
//	                },
//	                BirthDate: {
//	                    title: 'Birth date',
//	                    width: '15%',
//	                    type: 'date',
//	                    displayFormat: 'yy-mm-dd'
//	                },
//	                Education: {
//	                    title: 'Education',
//	                    list: false,
//	                    type: 'radiobutton',
//	                    options: { '1': 'Vietnam national university, Ha Noi', 
//	                               '2': 'Ha Noi university', 
//	                               '3': 'Thang Long university' }
//	                },
//	                About: {
//	                    title: 'About this person',
//	                    type: 'textarea',
//	                    list: false
//	                },
//	                IsActive: {
//	                    title: 'Status',
//	                    width: '12%',
//	                    type: 'checkbox',
//	                    values: { 'false': 'Passive', 'true': 'Active' },
//	                    defaultValue: 'true'
//	                },
//	                RecordDate: {
//	                    title: 'Record date',
//	                    width: '15%',
//	                    type: 'date',
//	                    displayFormat: 'dd.mm.yy',
//	                    create: false,
//	                    edit: false,
//	                    sorting: false //This column is not sortable!
//	                }
	            }
	        });
	 
	        //Load student list from server
	        $('#roleTableContainer').jtable('load');
});
