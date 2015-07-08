<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>
    ">
    <title>材料浏览页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="js/jqwidgets/styles/jqx.base.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxpanel.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxradiobutton.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="js/jqwidgets/jqxnotification.js"></script>
    <script type="text/javascript" src="js/generatedata.js"></script>
    <script type="text/javascript" src="js/demos.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var url = "admin/allMaterialList";

            // prepare the data
            var source =
            {
                dataType: "json",
                dataFields: [
                    { name: 'sn', type: 'string' },
                    { name: 'name', type: 'string' },
                    { name: 'department', type: 'string' },
                ],
                id: 'id',
                pageable: true,
                pagerPosition: 'both',
                url: url
            };

            var dataAdapter = new $.jqx.dataAdapter(source);

            $("#dataTable").jqxDataTable(
            {
                width: 640,
                pageable: true,
                pagerButtonsCount: 10,
                source: dataAdapter,
                columnsResize: true,
                selectionMode:'singleRow',
                columns: [
                  { text: '标识', dataField: 'sn', width: 40 }, 
                  { text: '材料名', dataField: 'name', width: 200 },
                  { text: '所属部门', dataField: 'department', width: 200 },
                  {
                   text: '操作', width: 200 ,
                      // row - row's index.
                      // column - column's data field.
                      // value - cell's value.
                      // rowData - rendered row's object.
                   cellsRenderer: function (row, column, value, rowData) {
                    console.log(rowData);
                    var detail = "<a href='admin/showMaterialInfo?sn="+(rowData.sn)+"'><button class='buy' style='margin: 5px; width: 80px; left: -40px; position: relative; margin-left: 50%; margin-bottom: 3px;'>详细</button></a>";
                        return detail;

                   }
               },
              ]
            });
            $("#dataTable").jqxDataTable({pagerMode:"advanced"});
            $("#myDeleteButton").jqxButton({ height: 25});
            $("#myEditButton").jqxButton({ height: 25});
            $("#myEditButton").bind('click',function(){
                var selection = $("#dataTable").jqxDataTable('getSelection');
                if(selection.length==0)
                {
                    alert("请先选择需要操作的行!");
                }else{
                   console.log(selection[0]);
                   window.location.href='admin/showMaterialInfo?sn='+selection[0]['sn'];
                }
            });
            $("#myDeleteButton").bind('click',function(){
                var selection = $("#dataTable").jqxDataTable('getSelection');
                if(selection.length==0)
                {
                    alert("请先选择需要操作的行!");
                }else{
                   var choice=confirm("您确定要删除此材料吗?");
                   if(choice==true)
                   {
                  /*   window.location.href='deleteAdminUser?userName='+selection[0]['username'];*/
                     $.ajax({
                        url:"admin/materialDelete",
                        data:{
                            materialId:selection[0]['sn']
                        },
                        dataType:'json',
                        success:function(data){
                            if(data.result=="success"){
                                alert("删除成功")
                                window.location.href='admin/materialList';
                            }
                            else{
                                alert("删除失败"); 
                            }
                        },
                        error:function(){
                            alert("加载失败！");
                        }
                     });
                   }
                }
            });
        });
    </script>
</head>
<body class='default'>
    <div id="dataTable"></div>
    <div id="myMenu" style="margin-top:20px">
        <button id="myDeleteButton">删除</button>
        <button id="myEditButton">编辑</button>
    </div>
</body>
</html>