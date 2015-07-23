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
  <title>材料详情页面</title>
</head>
<body>
	
<%-- 	<div class="container">
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
    </div>  --%>
    <table id="myMaterialTable" width="576" height="567" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="7">
			<img src="images/test_01.gif" width="159" height="340" alt=""></td>
		<td width="416" height="58" colspan="3">
			<img src="images/dot.gif" width="416" height="58" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="58" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<label>${myMaterial.name}</label>
		</td>
		<td>
			<img src="images/dot.gif" width="1" height="42" alt=""></td>
	</tr>
	<tr>
		<td width="416" height="57" colspan="3">
			<img src="images/dot.gif" width="416" height="57" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="57" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<div style="width:416px;height:80px">
				<label>${myMaterial.description}</label>	
			</div>
		</td>
		<td>
			<img src="images/dot.gif" width="1" height="80" alt=""></td>
	</tr>
	<tr>
		<td width="416" height="30" colspan="3">
			<img src="images/dot.gif" width="416" height="30" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="30" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<div style="width:416px;height:47px">
				<label>${myMaterial.department}</label>	
			</div>
		<td>
			<img src="images/dot.gif" width="1" height="47" alt=""></td>
	</tr>
	<tr>
		<td width="416" height="33" colspan="3" rowspan="2">
			<img src="images/dot.gif" width="416" height="33" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="26" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/test_09.gif" width="159" height="187" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="7" alt=""></td>
	</tr>
	<tr>
		<td width="19" height="220" rowspan="3">
			<img src="images/dot.gif" width="19" height="220" alt=""></td>
		<td rowspan="2">
			<img src="img/upload/${myMaterial.image}" width="353" height="195" alt=""></td>
		<td width="44" height="220" rowspan="3">
			<img src="images/dot.gif" width="44" height="220" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="180" alt=""></td>
	</tr>
	<tr>
		<td width="159" height="40" rowspan="2">
			<img src="images/dot.gif" width="159" height="40" alt=""></td>
		<td>
			<img src="images/dot.gif" width="1" height="15" alt=""></td>
	</tr>
</table>
</body>
</html>