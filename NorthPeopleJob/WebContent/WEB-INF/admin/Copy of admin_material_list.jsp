<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>材料增加</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<style type="text/css">
	.details_table td{
		border:1px solid black;
	}
</style>
</head>
<body>
	<table>
		<thread>
		<tr>
			<th>材料ID</th>
			<th>材料名称</th>
			<th>操作</th>
		</tr>
		</thread>
		<tbody>
			<c:forEach var="material" items="${myMaterialList}">
				<tr>
					<td>${material.sn}</td>
					<td>${material.name}</td>
					<td><button class="myButton">详细</button></td>
					<td><a href=""><button class="myDeleteButton">删除</button></a></td>
				</tr>
				<tr style="display: none" class="details">
					<td>
						<table style="border:1px solid black" class="details_table">
							<tr>
								<td>材料标识</td>
								<td>${material.sn}</td>
							</tr>
							<tr>
								<td>材料名称</td>
								<td>${material.name}</td>
							</tr>
							<tr>
								<td>图片:</td>
								<td width="300" height="200"><img
									src="./img/${material.image}" width="280" height="190"></td>
							</tr>
							<tr>
								<td>材料描述:</td>
								<td width="300" height="200">${material.description}</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		$(".myButton").bind("click",function(){
			$(this).parent().parent().siblings('.current').removeClass('current');
			$(this).parent().parent().next("tr").addClass('current');
			$(this).parent().parent().siblings('.details:not(.current)').slideUp("slow");
			$(this).parent().parent().next('tr').slideToggle("slow");
		});
		$(".myDeleteButton").bind("click",function(){

		});
	</script>
</body>
</html>