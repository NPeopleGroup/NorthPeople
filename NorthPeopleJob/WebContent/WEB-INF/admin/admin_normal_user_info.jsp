<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>
	">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>用户信息查看界面</title>
	<meta name="description" content="">
	<meta name="keywords" content="">
	<link href="css/register.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="assets/css/dpl-min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/bui-min.css">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui.js"></script>
	<script type="text/javascript" src="assets/js/config.js"></script>
	<script type="text/javascript" src="js/util.js"></script>
</head>
<body>
	<div class="container">
		<div class="jzzzl_box" style="float:left">
			<div class="jzzzl_box_main">
				<table width="778" border="0" cellspacing="10" cellpadding="0">
					<tbody>
						<tr>
							<td width="758">
								<table width="758" border="0" cellspacing="0" cellpadding="0">

									<tbody>
										<tr>
											<td height="25" colspan="6" align="center" valign="middle"
													bgcolor="#E4EDF2" class="jzzzl_box_main_font_01">
												基本信息 <font color="#FF0000">（红色标注项为必填项）</font>
												<span style="float:right">
													档案号:${fileNumber}
													<span></span>
												</span>
											</td>
										</tr>
										<tr>
											<td height="1" colspan="6" bgcolor="#F5F9FC"></td>
										</tr>
										<tr>
											<td height="1" colspan="6" bgcolor="#C3D0D9"></td>
										</tr>
										<tr>
											<td width="118" height="30" align="right" valign="middle" class="jzzzl_box_main_font_04">申请人类型&nbsp;</td>
											<td height="30" colspan="5" align="left" valign="middle" class="jzzzl_box_main_font_02">
												<label>
													<c:choose>
														<c:when test="${myUser.type=='1'}">企业员工</c:when>
														<c:when test="${myUser.type=='2'}">投资者</c:when>
														<c:otherwise>个体工商户</c:otherwise>
													</c:choose>
												</label>
											</td>
										</tr>
										<tr>
											<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
										</tr>
										<tr>
											<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">居住证/身份证号&nbsp;</td>
											<td height="30" colspan="5" align="left" valign="middle" class="jzzzl_box_main_font_02">
												<label style="font-size: 18px; font-weight: bold;">${myUser.cardID}</label>
											</td>
										</tr>
										<tr>
											<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
										</tr>
										<tr>
											<td height="30" align="right" valign="middle" class="jzzzl_box_main_font_04">姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;</td>
											<td width="150" height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
												<label  style="font-size: 12px;" id="name" >${myUser.name}</label>
											</td>
											<td width="100" height="30" align="right" valign="middle" class="jzzzl_box_main_font_04">性&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;</td>
											<td width="150" height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
												<label  style="font-color: red;">${myUser.sex}</label>

												<td width="100" height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">民&nbsp;&nbsp;&nbsp;&nbsp;族&nbsp;</td>
												<td width="150" height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
													<label>${myUser.nationality}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">出生日期&nbsp;</td>
												<td height="30" width="180px" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px">${myUser.birth}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">政治面貌&nbsp;</td>
												<td height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
													<label>${myUser.political}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">婚姻状况&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="width:130px;">${myUser.marriage }</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">文化程度&nbsp;</td>
												<td height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
													<label style="width: 130px;">${myUser.education}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">学&nbsp;&nbsp;&nbsp;&nbsp;位&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label id="degree" style="width: 130px;">${myUser.degree}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">专&nbsp;&nbsp;&nbsp;&nbsp;业&nbsp;</td>
												<td height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;" maxlength="50">${myUser.major}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">职业资格&nbsp;</td>
												<td height="30" colspan="3" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">${myUser.qualification}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">工&nbsp;&nbsp;&nbsp;&nbsp;种&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">${myUser.workTypes}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">迁出地省市县（区）&nbsp;</td>
												<td height="30" colspan="5" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													&nbsp;省（市自治区）
													<label style="width: 200px;">${myUser.fromProvincial }</label>
													&nbsp;&nbsp;&nbsp;市
													<label id="qcd_sj_sj" style="width: 285px;" tabindex="10">${myUser.fromCity }</label>
												</td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">&nbsp;</td>
												<td height="30" colspan="5" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;区（县）
													<label style="width: 200px;" >${myUser.fromDistrict }</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">迁出地详细地址&nbsp;</td>
												<td height="30" colspan="3" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;" class="textarea">${myUser.fromAddress}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">现户口性质&nbsp;</td>
												<td height="30" align="left" valign="middle" class="jzzzl_box_main_font_02">
													<label style="width: 130px;">${myUser.fromProperty}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">现户籍登记机关&nbsp;</td>
												<td height="30" colspan="5" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;"  class="textarea">${myUser.fromOrgan}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">迁入地户籍登记机关&nbsp;</td>
												<td height="30" colspan="5" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<div id="city_5">
														<label id="toOrgan" style="width: 240px;" >${myUser.toOrgan}</label>
														<label id="toPolicestation" style="width: 240px;" >${myUser.toPolicestation}</label>
													</div>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">迁入地详细地址&nbsp;</td>
												<td height="30" colspan="3" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label
													style="font-size: 12px;">${myUser.toAddress}</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">拟落户地区&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="width: 130px;" id="toDistrict" class="textarea">${myUser.toDistrict }</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">现单位名称&nbsp;</td>
												<td height="30" colspan="3" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">天津富强伟业精密五金有限公司</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">单位电话&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;" >15022781050</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">单位地址&nbsp;</td>
												<td height="30" colspan="3" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">天津市东丽区大毕庄工业区</label>
												</td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">本人电话&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">${myUser.phone}</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">社保缴纳&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-color: red;">${myUser.hasSocialsecurity }</label>
												</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_04"></td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04" colspan="2">积分期间有无行政拘留记录&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-color: red;">${myUser.hasDetention }</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<tr>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04">居住证申领日期&nbsp;</td>
												<td height="30" width="180px" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-size: 12px;">${myUser.residencePermitDate}</label>
												</td>

												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_04"></td>
												<td height="30" align="right" valign="middle"
													class="jzzzl_box_main_font_04" colspan="2">积分期间有无犯罪获刑记录&nbsp;</td>
												<td height="30" align="left" valign="middle"
													class="jzzzl_box_main_font_02">
													<label style="font-color: red;">${myUser.hasCriminal}&nbsp;&nbsp;</label>
												</td>
											</tr>
											<tr>
												<td height="1" colspan="6" background="./img/JZZZL_line.jpg"></td>
											</tr>
										</tbody>
									</table>

									<table width="758" border="0" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td height="25" colspan="5" align="center" valign="middle"
													bgcolor="#E4EDF2" class="jzzzl_box_main_font_01">父母配偶子女情况</td>
											</tr>
											<tr>
												<td height="1" colspan="5" bgcolor="#F5F9FC"></td>
											</tr>
											<tr>
												<td height="1" colspan="5" bgcolor="#C3D0D9"></td>
											</tr>
											<tr>
												<td height="30" align="center" width="125px;"
													valign="middle" class="jzzzl_box_main_font_02">与本人关系</td>
												<td height="30" align="center" width="125px;"
													valign="middle" class="jzzzl_box_main_font_02">姓名</td>

												<td height="30" align="center" width="292px;"
													valign="middle" class="jzzzl_box_main_font_02">身份证号</td>

												<td height="30" align="center" width="125px;"
													valign="middle" class="jzzzl_box_main_font_02">文化程度</td>
											</tr>
											<tr>
												<td height="1" colspan="5" background="./img/JZZZL_line.jpg"></td>
											</tr>
										</tbody>
										<tbody id="roles">
											<c:forEach var="myRelations" items="${myRelationList}">
												<tr>
													<td align="center" height="30px">
														<label style="text-align: left; width: 102px;">${myRelations.relation}</label>
													</td>
													<td align="center" height="30px">
														<label style="text-align: left; width: 102px;">${myRelations.relationName}</label>
													</td>
													<td align="center" height="30px">
														<label style="text-align: left; width: 102px;">${myRelations.relationIDCard}</label>
													</td>
													<td align="center" height="30px">
														<label style="text-align: left; width: 102px;">${myRelations.relationDegree}</label>
													</td>
												</tr>
											</c:forEach>
										</tbody>
										<!--循环开始-->
										<tbody>
											<tr>
												<td height="1" colspan="5" background="./img/JZZZL_line.jpg"></td>
											</tr>
											<!--循环结束-->
											<tr>
												<td height="60" colspan="5" align="center" valign="middle">
													<!-- <img src="./img/16.jpg" width="100" height="26"
													onclick="doConfirm1()" style="cursor: hand;">&nbsp;&nbsp; --></td>
											</tr>
											<tr>
												<td height="1" colspan="5" background="./img/JZZZL_line.jpg"></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div style="float:right">
				<button style='width:120px;height:30px;margin-top:50px' onclick="checkPage()">查看申请材料</button>
				<br>
				<button style='width:120px;height:30px;margin-top:50px' onclick="printContract()">打印合同</button>
				<br>
				<c:if test="${myUser.acceptionProgress=='1' }">
					<button style="width:120px;height:30px;margin-top:50px" onclick="editUserInfo()">编辑</button>
					<br>
					<button style="width:120px;height:30px;margin-top:50px" onclick="slUserInfo()">受理</button>

				</c:if>
				<c:if test="${myUser.acceptionProgress=='2' }">

					<button style="width:120px;height:30px;margin-top:50px" id="registerButton">登记</button>
					<br>
					<button style="width:120px;height:30px;margin-top:50px" onclick="UserInfo()">办结</button>

				</c:if>

				<!-- 此节点内部的内容会在弹出框内显示,默认隐藏此节点-->
				<div id="content" style="display:none">
					<form id="form" class="form-horizontal">
						<div class="row">
							<div class="control-group span8">
								<label class="control-label">预约时间：</label>
								<div class="controls">
									<input type="text" class="calendar"></div>
							</div>
						</div>
						<div class="row">
							<div class="control-group span15">
								<label class="control-label">备注：</label>
								<div class="controls control-row4">
									<textarea class="input-large" type="text"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>

				<script type="text/javascript">

			//弹出模态对话框
	        BUI.use('bui/overlay',function(Overlay){
		          var dialog = new Overlay.Dialog({
		            title:'模态窗口',
		            width:500,
		            height:250,
		            contentId:'content',
		            success:function () {
		              alert('确认');
		              this.close();
		            }
		          });
		        $('#registerButton').on('click',function () {
		          dialog.show();
		        });
		    });

		    //设置日历控件
			 BUI.use('bui/calendar',function(Calendar){
         		 var datepicker = new Calendar.DatePicker({
           		 trigger:'.calendar',
           		 autoRender : true
         		 });
      		  });
  			</script></div>
		</div>
		<script type="text/javascript">
		function checkPage(){
			window.location.href="checkFilePage";
		}
		function printContract(){
			
		}
		function editUserInfo(){
			window.location.href="admin/editUserInfo?userName=${myUser.username}";
		}
	</script>
</body>
	</html>