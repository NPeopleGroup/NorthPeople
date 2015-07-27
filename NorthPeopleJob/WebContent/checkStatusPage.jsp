<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link rel="icon" href="./img/website.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="./css/orderdetail2012.css">	
<link type="text/css" rel="stylesheet" href="./css/base1.css">
<link type="text/css" rel="stylesheet" href="./css/order_detail.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>查看受理状态</title>
</head>
<body>
	<label class="normal_label">${user.acceptionProgress}</label>
	<img src="images/section2.jpg" alt="">
	 <div style="width:840px;height:350px; position:absolute; top:20%; left:22%;background-color:#ffffff;border:1px solid #dedede;">
		  <div id="process" class="section4">
		            <div class="node fore ready"><ul><li class="tx1"></li><li class="tx2">提交申请</li><li id="track_time_0" class="tx3"></li></ul></div>
            		<div class="proce ready"><ul><li class="tx1"></li></ul></div>
            		<div class="node ready"><ul><li class="tx1"></li><li class="tx2">申请成功</li><li id="track_time_4" class="tx3"></li></ul></div>
            		<div class="proce ready"><ul><li class="tx1"></li></ul></div>
            		<div class="node ready"><ul><li class="tx1"></li><li class="tx2">正在受理</li><li id="track_time_4" class="tx3"></li></ul></div>
            		<div class="proce ready"><ul><li class="tx1"></li></ul></div>
            		<div class="node ready"><ul><li class="tx1"></li><li class="tx2">受理成功</li><li id="track_time_4" class="tx3"></li></ul></div>
            		<div class="proce doing"><ul><li class="tx1"></li></ul></div>		
            		<div class="node singular"><ul><li class="tx1"></li>受理完成</li><li id="track_time_4" class="tx3"></li></ul></div>
            </div>
            <div class="box order-dashboard" style="width:750px;margin-left:50px;">
			 	<div class="bd">
					<div class="trade-status"> 
					<strong>当前状态：<span class="wait">受理成功</span></strong>
					</div>
				<div class="tbnotes">
					<span style="color:#ED0002;">北方人才提醒您</span>
						<p>1、受理已经成功已经成功已经成功已经成功已经成功已经成功</p>
						<p>2、请等待通知，如有疑问请联系北方人才客服，客服电话：123456789</p>
			    </div>			
	        	</div>
          	</div>
         </div>
</body>
</html>