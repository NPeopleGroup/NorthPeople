<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="icon" href="./img/website.ico" type="image/x-icon" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>查看成绩</title>
</head>
<body>
	<s:iterator value="evaluationScoreList" id="evaluationScore">
		<s:property value="#evaluationScore.questionType" />：
		<s:property value="#evaluationScore.questionScore" />分<br>
	</s:iterator>
<div style="height:5%;"></div>
<center>
<p style="font-size:24px;font-weight:bold; font-family: sans-serif;">您的成绩</p>
</center>	
<center>
<table align="center" border=1 cellSpacing=0 borderColor=#dfdfdf borderColorLight=#dfdfdf borderColorDark=#dfdfdf cellPadding=0 width="68%">
<TR align="center" height=40px bgcolor="#eef2fb";><TD width="25%">年龄</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">文化程度</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb";><TD width="25%">专业技术和职业技能水平</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">住房</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb";><TD width="25%">社会保险</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">落户地区</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb"; ><TD width="25%">职业(工种)</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">投资纳税</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb";><TD width="25%">婚姻状况</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">奖项和荣誉称号</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb";><TD width="25%">工作年限</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px;><TD width="25%">守法诚信</TD><TD width="25%">12</TD></TR>
<TR align="center" height=40px  bgcolor="#eef2fb";><TD width="25%">合计</TD><TD width="25%">12</TD></TR>
</table>
</center>
</body>
</html>