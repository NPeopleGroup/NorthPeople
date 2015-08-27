<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!-- 判断是否查询所有信息
	1.代表未受理用户
	2.代表已受理用户
	3.代表已完结用户
 -->
<%
	String status = request.getParameter("status");
	String url = "admin/allUserList";
	if (status != null) {
		url += "?type=" + status;
	}
%>

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

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="js/jqwidgets/styles/jqx.base.css"
	type="text/css" />
<link rel="stylesheet" href="css/MasterPage.css" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/bootstrap.min.css">
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
<style type="text/css">
.myOperationButton {
	width: 80px;
	height: 30px;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var url = "<%=url%>";
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
				name : 'name',
				type : 'string'
			}, {
				name : 'sex',
				type : 'string'
			}, {
				name : 'type',
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
				text : 'Name',
				dataField : 'name',
				width : 120
			}, {
				text : 'Sex',
				dataField : 'sex',
				width : 200
			}, {
				text : 'Type',
				dataField : 'type',
				width : 180
			}, ]
		});
		$("#dataTable").jqxDataTable({
			pagerMode : "advanced"
		});
		$("#myDeleteButton").bind('click', function() {
			var selection = $("#dataTable").jqxDataTable('getSelection');
			if (selection.length == 0) {
				alert("请先选择需要操作的行!");
			} else {
				var choice = confirm("您确定要删除此业务员吗?");
				if (choice == true) {
					/*   window.location.href='deleteAdminUser?userName='+selection[0]['username'];*/
					$.ajax({
						url : "admin/userDelete",
						data : {
							userName : selection[0]['username']
						},
						dataType : 'json',
						success : function(data) {
							if (data.result == "success") {
								alert("删除成功")
								window.location.href = 'admin/userList';
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
	<div id="pagetitle">
		<%
			if (status != null) {
				if (status.equals("1"))
					out.println("未受理用户列表");
				else if (status.equals("2")) {
					out.println("已受理用户列表");
				} else {
					out.println("已完结用户列表");
				}
			} else {
				out.println("所有用户列表");
			}
		%>
	</div>
	<div></div>
	<div id="workzone" style="width: 725px; margin: 30px auto;">
		<div id="dataTable"></div>
	</div>
	<div id="button" style="width: 725px; margin: 30px auto;">
		<div id="myMenu" style="margin-top: 20px">
			<button id="myDeleteButton" class="myOperationButton">删除</button>
			<%
				if (status != null &&( status.equals("1")||status.equals("2"))) {
			%>
			<button id="myEditButton" class="myOperationButton"
				onclick="myEditHandler()">查看</button>
			<%
				}
			%>
			<button id="statu1Button" onclick="wslFunciton()"
				class="myOperationButton">未受理</button>
			<button id="statu2Button" onclick="yslFunction()"
				class="myOperationButton">已受理</button>
			<button id="statu3Button" onclick="ybjFunction()"
				class="myOperationButton">已办结</button>
		</div>
	</div>

	<script type="text/javascript">
		function wslFunciton() {
			window.location.href = "admin/userList?status=1";
		}
		function yslFunction() {
			window.location.href = "admin/userList?status=2";
		}
		function ybjFunction() {
			window.location.href = "admin/userList?status=3";
		}
		function myEditHandler() {
			var selection = $("#dataTable").jqxDataTable('getSelection');
			if (selection.length == 0) {
				alert("请先选择需要操作的行!");
			} else {
				console.log(selection[0]);
				window.location.href = 'admin/showUserInfo?userName='
						+ selection[0]['username'];
			}
		}
	</script>
</body>
</html>
