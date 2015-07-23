<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="./js/jquery.js"></script>
<link rel="stylesheet" href="./css/admin-question.css">
<link rel="stylesheet" href="./js/jqwidgets/styles/jqx.base.css"
	type="text/css" />
<script type="text/javascript" src="./js/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="./js/jqwidgets/jqxtabs.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript">
	$(function() {
		$(".normal_button").jqxButton({
			height : 35,
			width : 80
		});
		$('#jqxTabs').jqxTabs({
			width : '90%',
			height : 600,
			position : 'top'
		});
		$('#settings div').css('margin-top', '10px');
	});
</script>
<style type="text/css">
#preview {
	width: 300px;
	height: 210px; border : 1px solid #c7c7c7;
	overflow: hidden;
	border: 1px solid #c7c7c7;
}

#imghead {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
}
</style>
</head>
<body>

	<form id="myFrom" class="form-horizontal span24"
		action="admin/addAdminUser" method="post">
		<div style="float: left; width: 33%; height: 100%">
			<div class="form_item">
				<label class="normal_label">用户名:</label> <input type="text"
					name="username" class="normal_input" />
			</div>
			<div class="form_item">
				<label class="normal_label">密码:</label> <input type="password"
					name="password" class="normal_input" />
			</div>
			<div class="form_item">
				<label class="normal_label">用户类型:</label> <select name="type"
					class="normal_select">
					<option value="超级管理员">超级管理员</option>
					<option value="业务经理">业务经理</option>
					<option value="业务员">业务员</option>
				</select>
			</div>

			<div class="form_item">
				<label class="normal_label">用户姓名:</label> <input type="text"
					name="name" class="normal_input" />
			</div>

			<div class="form_item">
				<button type="submit" class="normal_button">确认</button>
			</div>
		</div>
	</form>

</body>
</html>