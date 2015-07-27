<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="./js/jquery.js"></script>
<link rel="stylesheet" href="./css/public.css">
<script language="javascript">
	function jumpConfirm(englishType, chineseType) {
		if (confirm("跳转到\"" + chineseType + "\"分类,进行答题吗？")) {
			window.location.href = "answerQuestionPageSubmit?type="
					+ englishType;
		}
	}
</script>

<script type="text/javascript">
	//调整Question页面的高度
	$(function() {
		if (window.innerHeight) {
			winHeight = window.innerHeight;
			/* 			$(".question-box").css("margin-top",
			 (winHeight - 70 - 150 - 452) / 3); */
			$(".question-box").css("margin-bottom",
					(winHeight - 70 - 150 - 452) / 3 * 2);
		}
	});
	$(document)
			.ready(
					function() {

						var unFinishedType = "${unFinishedType}";

						if (unFinishedType == "") {
							if (confirm("全部答题完毕，要跳转到查看分数的页面吗？")) {
								window.location.href = "checkScorePage";
							}
						}

						var count = 0;

						if (unFinishedType.indexOf("<年龄>") == -1) {
							$("#age_finish").attr("src", "./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<教育>") == -1) {
							$("#education_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<技能(职业资格)>") == -1) {
							$("#skills_qualifications_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<技能(职称)>") == -1) {
							$("#skills_title_finish").attr("src",
									"./img/finished.png");
							count++;

						}
						if (unFinishedType.indexOf("<住房>") == -1) {
							$("#housing_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<社保>") == -1) {
							$("#security_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<落户地区>") == -1) {
							$("#settled_area_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<职业>") == -1) {
							$("#career_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<投资纳税>") == -1) {
							$("#investment_tax_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<奖项荣誉>") == -1) {
							$("#awards_honor_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<婚姻状况>") == -1) {
							$("#marital_status_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<工作年限>") == -1) {
							$("#working_years_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						if (unFinishedType.indexOf("<守法诚信>") == -1) {
							$("#law_integrity_finish").attr("src",
									"./img/finished.png");
							count++;
						}
						$(".question-box-line-fill").css("width",
								count / 13 * 772);

						if ("${question.activationA}" != "on") {
							$("#option_a_li").hide();
						}

						if ("${question.activationB}" != "on") {
							$("#option_b_li").hide();
						}

						if ("${question.activationC}" != "on") {
							$("#option_c_li").hide();
						}

						if ("${question.activationD}" != "on") {
							$("#option_d_li").hide();
						}

						if ("${question.activationE}" != "on") {
							$("#option_e_li").hide();
						}

						if ("${question.activationF}" != "on") {
							$("#option_f_li").hide();
						}
					});
</script>

</head>
<body>

	<form id="answerQuestion" method="post" enctype="multipart/form-data"
		action="answerQuestionPageSubmit?from=${from}&id=${id}&type=${type}">
		<input type="text" name="id" value="${question.id}"
			style="display: none" />
			<img src="images/section2.jpg" alt="">
	<div style="width:1030px;height:475px;background-color:#ffffff;border:1px solid #dedede;position:absolute;top:15%;left:15%;">
	
		<div style="width: 990px;margin:0px auto;margin-top:10px;border:1px solid #eeeeee;">
			<div style="width: 170px; float: left;style="border:1px solid #eeeeee;">
				<div class="type-box" ">
					<img src="img/age.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="age_finish" /><a href="#"
						onclick="jumpConfirm('age','年龄');">年龄</a>
				</div>
				<div class="type-box">
					<img src="img/education.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="education_finish" /><a
						href="#" onclick="jumpConfirm('education','教育');">教育</a>
				</div>
				<div class="type-box">
					<img src="img/skills_qualifications.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left"
						id="skills_qualifications_finish" /><a href="#"
						onclick="jumpConfirm('skills_qualifications','技能(职业资格)');">技能(职业资格)</a>
				</div>
				<div class="type-box">
					<img src="img/skills_title.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="skills_title_finish" /><a
						href="#" onclick="jumpConfirm('skills_title','技能(职称)');">技能(职称)</a>
				</div>
				<div class="type-box">
					<img src="img/housing.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="housing_finish" /><a
						href="#" onclick="jumpConfirm('housing','住房');">住房</a>
				</div>
				<div class="type-box">
					<img src="img/security.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="security_finish" /><a
						href="#" onclick="jumpConfirm('security','社保');">社保</a>
				</div>
				<div class="type-box">
					<img src="img/settled_area.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="settled_area_finish" /><a
						href="#" onclick="jumpConfirm('settled_area','落户地区');">落户地区</a>
				</div>
				<div class="type-box">
					<img src="img/career.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="career_finish" /><a
						href="#" onclick="jumpConfirm('career','职业');">职业</a>
				</div>
				<div class="type-box">
					<img src="img/investment_tax.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="investment_tax_finish" /><a
						href="#" onclick="jumpConfirm('investment_tax','投资纳税');">投资纳税</a>
				</div>
				<div class="type-box">
					<img src="img/awards_honor.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="awards_honor_finish" /><a
						href="#" onclick="jumpConfirm('awards_honor','奖项荣誉');">奖项荣誉</a>
				</div>
				<div class="type-box">
					<img src="img/marital_status.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="marital_status_finish" /><a
						href="#" onclick="jumpConfirm('marital_status','婚姻状况');">婚姻状况</a>
				</div>
				<div class="type-box">
					<img src="img/working_years.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="working_years_finish" /><a
						href="#" onclick="jumpConfirm('working_years','工作年限');">工作年限</a>
				</div>
				<div class="type-box">
					<img src="img/law_integrity.png" width="35px" height="35px"
						style="float: left" /> <img src="img/unfinished.png" width="19px"
						height="35px" style="float: left" id="law_integrity_finish" /><a
						href="#" onclick="jumpConfirm('law_integrity','守法诚信');">守法诚信</a>
				</div>
			</div>
			<div class="question-box" style="border:1px solid #eeeeee;">
				<div class="question-box-title">天津市积分落户自助测评</div>
				<div class="question-box-line">
					<div class="question-box-line-fill"></div>
				</div>
				<div class="question-box-question">
					<div class="question-box-text">
						<div class="question-box-stem">${question.question}</div>
						<div class="question-box-option">
							<ul>
								<li id="option_a_li"><i></i> <input type="radio"
									name="option" value="A_${question.gotoA}" checked="true">
									A. ${question.choiceA}</li>
								<li id="option_b_li"><i></i> <input type="radio"
									name="option" value="B_${question.gotoB}"> B.
									${question.choiceB}</li>
								<li id="option_c_li"><i></i> <input type="radio"
									name="option" value="C_${question.gotoC}"> C.
									${question.choiceC}</li>
								<li id="option_d_li"><i></i> <input type="radio"
									name="option" value="D_${question.gotoD}"> D.
									${question.choiceD}</li>
								<li id="option_e_li"><i></i> <input type="radio"
									name="option" value="E_${question.gotoE}"> E.
									${question.choiceE}</li>
								<li id="option_f_li"><i></i> <input type="radio"
									name="option" value="F_${question.gotoF}"> F.
									${question.choiceF}</li>
							</ul>
						</div>
					</div>
					<div class="question-box-picture">
						<img src="img/question-${question.id}.png" width="400"
							height="280" />
					</div>
				</div>
				<input class="question-box-submit" value="上一题"
					onclick="location.href='answerQuestionPageBack?from=${from}&id=${id}&type=${type}'"></input>
				<input class="question-box-submit" value="下一题" type="submit"></input>
				<div class="question-box-progress"></div>
			</div>
		</div>
		</div>
	</form>
</body>
</html>