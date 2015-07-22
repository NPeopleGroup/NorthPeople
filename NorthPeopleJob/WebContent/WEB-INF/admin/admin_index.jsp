<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>北方人才后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="../assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!--页面头部 start -->
  <div class="header">
    
      <div class="dl-title">
          <span class="lp-title-port">北方人才</span><span class="dl-title-text">后台管理系统</span>
      </div>

    <div class="dl-log">欢迎您，
    <span class="dl-log-user">
   <%=session.getAttribute("NorthPeopleJob_adminusername")%> 	
    </span><a href="###" title="退出系统" class="dl-log-quit">[退出]</a></div>
  </div>

<!--页面头部 end -->


<!--mainbody start -->
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">业务员管理</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-order">普通用户管理</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-order">材料管理</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-marketing">其他页面</div></li>
        <li class="nav-item"><div class="nav-item-inner nav-marketing">问题管理页面</div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
<!--mainbody end -->

  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../assets/js/bui.js"></script>
  <script type="text/javascript" src="../assets/js/config.js"></script>

  <script>
    BUI.use('common/main',function(){
      var config = [{
          id:'menu', 
          homePage : 'admin_user_list',
          menu:[{
              text:'业务员管理',
              items:[
                {id:'admin_user_list',text:'浏览用户',href:'admin/adminUserList',closeable : false},
                {id:'admin_user_addmenu',text:'增加用户',href:'admin/adminUserAdd'},
              ]
            }]
          },{
            id:'user',
            homePage:'user_list',
            menu:[{
                text:'用户管理页面',
                items:[
                  {id:'user_list',text:'用户浏览',href:'admin/userList'},
                  {id:'user_add',text:'增加用户',href:'admin/userAdd'},
                ]
              }]
          },{
            id:'material',
            homePage:'material_list',
            menu:[{
                text:'材料管理',
                items:[
                  {id:'material_list',text:'材料浏览',href:'admin/materialList'},
                  {id:'material_add',text:'材料增加',href:'admin/materialAdd'},
                ]
              }]
          },{
            id:'detail',
            menu:[{
                text:'详情页面',
                items:[
                  {id:'code',text:'详情页面代码',href:'detail/code.html'},
                  {id:'example',text:'详情页面示例',href:'detail/example.html'},
                  {id:'introduce',text:'详情页面简介',href:'detail/introduce.html'}
                ]
              }]
          },{
              id:'question',
              menu:[{
                  text:'问题管理页面',
                  items:[
                    {id:'user_list',text:'问题浏览-年龄',href:'admin/adminQuestionListPage?questionType=age'},
                    {id:'user_list',text:'问题浏览-教育',href:'admin/adminQuestionListPage?questionType=education'},
                    {id:'user_list',text:'问题浏览-技能(职称)',href:'admin/adminQuestionListPage?questionType=skills_title'},
                    {id:'user_list',text:'问题浏览-技能(职业资格)',href:'admin/adminQuestionListPage?questionType=skills_qualifications'},
                    {id:'user_list',text:'问题浏览-住房',href:'admin/adminQuestionListPage?questionType=housing'},
                    {id:'user_list',text:'问题浏览-社保',href:'admin/adminQuestionListPage?questionType=security'},
                    {id:'user_list',text:'问题浏览-落户地区',href:'admin/adminQuestionListPage?questionType=settled_area'},
                    {id:'user_list',text:'问题浏览-职业',href:'admin/adminQuestionListPage?questionType=career'},
                    {id:'user_list',text:'问题浏览-投资纳税',href:'admin/adminQuestionListPage?questionType=investment_tax'},
                    {id:'user_list',text:'问题浏览-奖项荣誉',href:'admin/adminQuestionListPage?questionType=awards_honor'},
                    {id:'user_list',text:'问题浏览-婚姻状况',href:'admin/adminQuestionListPage?questionType=marital_status'},
                    {id:'user_list',text:'问题浏览-工作年限',href:'admin/adminQuestionListPage?questionType=working_years'},
                    {id:'user_list',text:'问题浏览-守法诚信',href:'admin/adminQuestionListPage?questionType=law_integrity'}
                  ]
                }]
            }];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
</body>
</html>