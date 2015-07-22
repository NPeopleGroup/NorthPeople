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
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="css/admin-question.css">
<link rel="stylesheet" href="js/jqwidgets/styles/jqx.base.css"
	type="text/css" />
<script type="text/javascript" src="js/jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxtabs.js"></script>
<script type="text/javascript" src="js/jqwidgets/jqxbuttons.js"></script>
<script src="js/jquery-validation/lib/jquery.js"></script>
<script src="js/jquery-validation/dist/jquery.validate.js"></script>

<style type="text/css">
#preview {
	width: 300px; height: 210px; border: 1px solid #c7c7c7; overflow: hidden;
}

#imghead {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
}
.form_item{
	width:80%;
}
</style>
</head>
<body>
	<form action="admin/addUser" method="post" id="myUserForm">
		<div style="width: 60%; height: 100%;margin:0 auto">
			<div class="form_item">
				<label class="normal_label">用户名:</label> <input type="text"
					name="username" id="username" class="normal_input onlyNumber" />
			</div>
			<div class="form_item">
				<label class="normal_label">密码:</label> <input type="password"
					name="password" id="password" class="normal_input" />
			</div>
			<div class="form_item">
				<button type="submit" class="normal_button" id="mySubmitButton">确认</button>
			</div>
		</div>		
	</form>
		


	<script type="text/javascript">
		$(function(){
			$("#myUserForm").validate({
				rules:{
					username:{
						required:true,
						digits:true,
						maxlength:11,
						minlength:11
					}
				},
				messages:{
					username:{
						required:"用户名为空",
						digits:"请您输入11位手机号码",
						maxlength:"请检查手机号码长度",
						minlength:"请检查手机号码长度"
					}
				}
			});
		});
	
	</script>

</body>
</html>