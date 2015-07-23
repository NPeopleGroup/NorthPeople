<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员浏览页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="js/jqwidgets/styles/jqx.base.css"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/MasterPage.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxlistbox.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxdatatable.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxpanel.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxradiobutton.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxinput.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxnotification.js"></script>
<script type="text/javascript" src="js/generatedata.js"></script>
<script type="text/javascript" src="js/demos.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var url = "admin/allAdminUserList";

						// prepare the data
						var source = {
							dataType : "json",
							dataFields : [ {
								name : 'sn',
								type : 'string'
							}, {
								name : 'username',
								type : 'string'
							}, {
								name : 'password',
								type : 'string'
							}, {
								name : 'type',
								type : 'string'
							}, {
								name : 'name',
								type : 'string'
							}, ],
							id : 'id',
							pageable : true,
							pagerPosition : 'both',
							url : url
						};

						var dataAdapter = new $.jqx.dataAdapter(source);

						$("#dataTable").jqxDataTable({
							width : 725,
							pageable : true,
							pagerButtonsCount : 10,
							source : dataAdapter,
							columnsResize : true,
							selectionMode : 'singleRow',
							columns : [ {
								text : 'Id',
								dataField : 'sn',
								width : 20
							}, {
								text : 'UserName',
								dataField : 'username',
								width : 200
							}, {
								text : 'User Password',
								dataField : 'password',
								width : 200
							}, {
								text : 'Type',
								dataField : 'type',
								width : 180
							}, {
								text : 'Name',
								dataField : 'name',
								width : 120
							} ]
						});
						$("#dataTable").jqxDataTable({
							pagerMode : "advanced"
						});
						$("#myEditButton").jqxButton({
							height : 35,
							width : 80
						});
						$("#myDeleteButton").jqxButton({
							height : 35,
							width : 80
						});
						$("#myEditButton")
								.bind(
										'click',
										function() {
											var selection = $("#dataTable")
													.jqxDataTable(
															'getSelection');
											if (selection.length == 0) {
												alert("请先选择需要操作的行!");
											} else {
												console.log(selection[0]);
												window.location.href = 'admin/showAdminUserInfo?userName='
														+ selection[0]['username'];
											}
										});
						$("#myDeleteButton")
								.bind(
										'click',
										function() {
											var selection = $("#dataTable")
													.jqxDataTable(
															'getSelection');
											if (selection.length == 0) {
												alert("请先选择需要操作的行!");
											} else {
												var choice = confirm("您确定要删除此业务员吗?");
												if (choice == true) {
													/*   window.location.href='deleteAdminUser?userName='+selection[0]['username'];*/
													$
															.ajax({
																url : "admin/deleteAdminUser",
																data : {
																	userName : selection[0]['username']
																},
																dataType : 'json',
																success : function(
																		data) {
																	if (data.result == "success") {
																		alert("删除成功")
																		window.location.href = 'admin/adminUserList';
																	} else {
																		alert("删除失败");
																	}
																},
																error : function() {
																	alert("加载失败！");
																}
															});
												}
											}
										});
					});
</script>
</head>
<body class='default'>


	<div id="pagetitle">用户管理页面</div>
	<div id="workzone" style="width: 725px; margin: 30px auto;">
		<div id="dataTable"></div>
	</div>
	<div id="button" style="width: 725px; margin: 30px auto;">
		<div id="myMenu" style="margin-top: 20px">
			<button id="myDeleteButton">删除</button>
			<button id="myEditButton">编辑</button>
		</div>
	</div>


</body>
</html>
