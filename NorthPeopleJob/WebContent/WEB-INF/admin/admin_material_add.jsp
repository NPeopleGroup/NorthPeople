<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
	<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
	<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="container" style="margin-top:300px">
		<div class="row">
			<form id="myFrom" class="form-horizontal span24" enctype="multipart/form-data" method="post" action="admin/addMaterial">
				<legend>增加材料</legend>
				<div class="row">
					<div class="control-group span12">
						<label class="control-label">
							<s>*</s>
							材料名称
						</label>
						<div class="controls">
							<input type="text" name="name"/>
						</div>
					</div>
					<div class="control-group span12">
						<label class="control-label">
							<s>*</s>
							材料图片
						</label>
						<div class="controls">
							<input type="file" name="image"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span12">
						<label class="control-label">
							<s>*</s>
							材料描述
						</label>
						<div class="controls">
							<textarea class="input-large" type="text" name="description"></textarea>
						</div>
					</div>
					<div class="control-group span12">
						<label class="control-label">
							<s>*</s>
							所属部门
						</label>
						<div class="controls">
							<select name="department">
								<option>部门一</option>	
								<option>部门二</option>	
								<option>部门三</option>	
								<option>部门四</option>	
								<option>部门五</option>	
								<option>部门六</option>	
								<option>部门七</option>	
							</select>	
						</div>
					</div>
				</div>
				<div class="row form-actions actions-bar">
					<div class="span13 offset3 ">
						<input type="submit" class="button button-primary" id="mySubmitButton"></input>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>