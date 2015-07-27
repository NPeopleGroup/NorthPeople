<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="icon" href="./img/website.ico" type="image/x-icon" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>所需材料</title>
</head>
<body>
	<s:iterator value="evaluationFileList" id="evaluationFile">
		<s:if test="#evaluationFile.questionFile!=''">	
		请您携带&nbsp;<s:property value="#evaluationFile.questionFile" />&nbsp;到
		 &nbsp;<s:property value="#evaluationFile.questionDepartment" /> &nbsp;登机，并注意
		<s:property value="#evaluationFile.questionHint" />
			<br>
		</s:if>
	</s:iterator>
   <center style="margin-top:4%">
<p style="font-size:24px;font-weight:bold; font-family: sans-serif;">您需要提供如下材料</p>
</center>	
   <center>
<table id="table1" align="center" border=1 cellSpacing=0 borderColor=#dfdfdf borderColorLight=#dfdfdf borderColorDark=#dfdfdf cellPadding=0 width="48%">
<TR align="center" height=30px bgcolor="#eef2fb";><TD width="25%">材料名称</TD><TD width="25%">额外说明</TD></TR>
<TR align="center" height=30px;><TD width="25%">身份证</TD><TD width="25%">复印件</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">结婚证</TD><TD width="25%">要求民政局盖章清晰</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">社保缴费清单</TD><TD width="25%">详细列出所有缴费</TD></TR>
<TR align="center" height=30px;><TD width="25%">教师证</TD><TD width="25%">复印件即可</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">身份证</TD><TD width="25%">复印件</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">身份证</TD><TD width="25%">复印件</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">身份证</TD><TD width="25%">复印件</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">身份证</TD><TD width="25%">复印件</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">户口本</TD><TD width="25%">需要您携带原件</TD></TR>
<TR align="center" height=30px;><TD width="25%">结婚证</TD><TD width="25%">要求民政局盖章清晰</TD></TR>
<TR align="center" height=30px  bgcolor="#eef2fb";><TD width="25%">社保缴费清单</TD><TD width="25%">详细列出所有缴费</TD></TR>
</table>
</center>
</body>
</html>