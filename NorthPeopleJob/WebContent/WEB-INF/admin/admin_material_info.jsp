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
  <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/page-min.css" rel="stylesheet" type="text/css" />
  <title>材料详情页面</title>
</head>
<body>
	
	<div class="container">
    <div class="row">
      <form action="" class="form-horizontal form-horizontal-simple">
        <div class="control-group">
          <label class="control-label">材料名称：</label>
          <div class="controls">
            <span class="control-text">${myMaterial.name}</span>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label">材料描述：</label>
          <div class="controls">
            <span class="control-text">${myMaterial.description}</span>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label">所属部门：</label>
          <div class="controls">
            <span class="control-text">${myMaterial.department}</span>
          </div>
        </div>
        <div class="control-group">
          <label class="control-label">材料图片：</label>
          <div class="controls control-row-auto">
            <img width="285" src="img/upload/${myMaterial.image}">
          </div>
        </div>
      </form> 
    </div> 
</body>
</html>