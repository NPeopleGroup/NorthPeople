<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	$(document).ready(function() {
		$(".normal_button").jqxButton({
			height : 35,
			width : 80
		});

		$('#animation').on('change', function(event) {
			var checked = event.args.checked;
			$('#jqxTabs').jqxTabs({
				selectionTracker : checked
			});
		});

		$('#contentAnimation').on('change', function(event) {
			var checked = event.args.checked;
			if (checked) {
				$('#jqxTabs').jqxTabs({
					animationType : 'fade'
				});
			} else {
				$('#jqxTabs').jqxTabs({
					animationType : 'none'
				});
			}
		});
	});
</script>
<style type="text/css">
#preview {
	width: 300px; height: 210px; border: 1px solid #c7c7c7; overflow: hidden;
}

#imghead {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
}
</style>

<script type="text/javascript">
	function previewImage(file) {
		var MAXWIDTH = 300;
		var MAXHEIGHT = 210;
		var div = document.getElementById('preview');
		if (file.files && file.files[0]) {
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, MAXWIDTH,
						MAXHEIGHT);
				img.width = rect.width;
				img.height = rect.height;
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		} else {
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
		}
	}
	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top : 0,
			left : 0,
			width : width,
			height : height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;

			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}

		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
	}
</script>
</head>
<body>

	<form id="myFrom" class="form-horizontal span24" enctype="multipart/form-data" method="post" action="admin/addMaterial">
		<div style="float: left; width: 33%; height: 100%">
			<div class="form_item">
				<label class="normal_label">材料名称:</label> <input type="text"
					name="name" class="normal_input" />
			</div>
			<div class="form_item">
				<label class="normal_label">材料描述:</label> <input type="text"
					name="description" class="normal_input" />
			</div>
			<div class="form_item">
				<label class="normal_label">所属部门:</label> <select name="department"
					class="normal_select">
					<option value="年龄">年龄</option>
					<option value="教育">教育</option>
					<option value="技能(职称)">技能(职称)</option>
					<option value="技能(职业资格)">技能(职业资格)</option>
					<option value="住房">住房</option>
					<option value="社保">社保</option>
					<option value="落户地区">落户地区</option>
					<option value="职业">职业</option>
					<option value="投资纳税">投资纳税</option>
					<option value="奖项荣誉">奖项荣誉</option>
					<option value="婚姻状况">婚姻状况</option>
					<option value="工作年限">工作年限</option>
					<option value="守法诚信">守法诚信</option>
				</select>
			</div>
		
			<div class="form_item">
				<label class="normal_label">材料图片:</label> <input type="file"
					name="image" class="normal_input" onchange="previewImage(this)" />
			</div>
			<div class="form_item" id="preview" style="height: 210px">
			
				<img src="img/question-${question.id}.png" width="300" height="210"
					id="imghead" />
			</div>
			<div class="form_item">
				<button type="submit" class="normal_button">确认</button>
			</div>
		</div>
	</form>

</body>
</html>