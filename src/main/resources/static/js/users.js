
$(document).ready(function() {
	        $('#userTableContainer').jtable({
	            title: 'The User List',
	            paging: true, //Enable paging
	            pageSize: 10, //Set page size (default: 10)
	            sorting: true, //Enable sorting
	            defaultSorting: 'Name ASC', //Set default sorting
	            actions: {
	                listAction: '/user/userList',
	                deleteAction: '/user/deleteUser',
	                updateAction: '/user/updateUser'
	           /*     createAction: '/user/addUser'*/
	            },
	            fields: {
				id : {
							key : true,
							create : false,
							edit : false,
							list : false
						},
						username : {
							title : 'Username',
							width : '23%',
							create : false,
							edit : false,
							list : true
						},
						firstName :
						{
							title : 'First Name',
							width :'23%',
							create : false,
							edit : false,
							list : true
						},
						lastName :
						{
							title : 'Last Name',
							width :'23%',
							create : false,
							edit : false,
							list : true
						},
						email :
						{
							title : 'Email',
							width :'23%',
							create : false,
							edit : false,
							list : true
						},
						roleId: {
							inputClass : 'selectpicker',
		                    title: 'Role',
		                    create : false,
		                    list: true,
		                    options: function(data) {
		                        if (data.source == 'list') {
		                            //Return url all options for optimization. 
		                            return '/role/userRoleforUser?username=' + data.record.username;//'/role/userRoleforUser?username=test123';
		                        }
		                        //This code runs when user opens edit/create form to create combobox.
		                        //data.source == 'edit' || data.source == 'create'
		                        return '/role/userRoles';
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
	        $('#userTableContainer').jtable('load');
});
