<%--
  Created by IntelliJ IDEA.
  User: LicolnLee
  Date: 10/24/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改销售表单信息</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var commodityid =document.getElementById("commodityid").value;
            var merchandisingid =document.getElementById("merchandisingid").value;
            var gsNum =document.getElementById("gsNum").value;
            var gsje =document.getElementById("gsje").value;
            var gsylje =document.getElementById("gsylje").value;
            var username=document.getElementById("username").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (commodityid==null|| commodityid==""){
                alert("请填写商品ID");
                document.getElementById("commodityid").focus();
            }else if (merchandisingid==null || merchandisingid==""){
                alert("请填写销售表单号");
                document.getElementById("merchandisingid").focus();
            }
            else if (gsNum==null || gsNum==""){
                alert("请填写销售数量");
                document.getElementById("gsNum").focus();
            }
            else if(gsje==null || gsje==""){
                alert("请填写销售金额");
                document.getElementById("gsje").focus();
            }
            else if(gsylje==null || gsylje==""){
                alert("请选择销售盈利");
                document.getElementById("gsylje").focus();
            }
            else if(username==null || username==""){
                alert("请填写销售提交用户名");
                document.getElementById("userName").focus();
            }
            else if(userpass==null || userpass==""){
                alert("请填写商品提交登陆密码");
                document.getElementById("userpass").focus();
            }
            else if(repass==null || repass==""){
                alert("请确认密码");
                document.getElementById("repass").focus();
            }
            else if(userpass!=repass){
                alert("确认密码不相符!");
                document.getElementById("repass").value=null;
                document.getElementById("repass").focus();
            }
            else{
                document.regist.submit;
            }
        }
        function res() {
            document.getElementsByName("commodityid").value=null;
            document.getElementsByName("merchandisingid").value=null;
            document.getElementsByName("gsNum").value=null;
            document.getElementsByName("gsje").value=null;
            document.getElementsByName("gsylje").value=null;
            document.getElementsByName("userName").value=null;
            document.getElementsByName("userPass").value=null;
            document.getElementsByName("rePass").value=null;
        }
        function ret() {
            window.location.back(-1);
        }

    </script>
    <script type="text/javascript" src="js/year_month_day.js"></script>
</head>
<body class="login">
<form action="" method="" name="regist">
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>修改销售信息</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="Add_content">
                    <tbody>
                    <tr>
                        <td class="Add_font">商品ID：</td>
                        <td>
                            <input type="text" name="commodityid" id="commodityid"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">销售表ID：</td>
                        <td>
                            <input type="text" name="merchandisingid" id="merchandisingid" size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">销售数量：</td>
                        <td>
                            <input type="text" name="gsNum" id="gsNum"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">销售金额：</td>
                        <td>
                            <input type="text" name="gsje" id="gsje"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">销售盈利：</td>
                        <td>
                            <input type="text" name="gsylje"  id="gsylje"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font" colspan="2" text align="center">&nbsp;&nbsp;&nbsp;请为该商品设置其登陆账户和密码：</td>
                    </tr>
                    <tr>
                        <td class="Add_font">用户提交名：</td>
                        <td>
                            <input type="text" name="userName" id="userName"  size="30" class="Add_input">
                        </td>
                    </tr>

                    <tr>
                        <td class="Add_font">用户提交密码：</td>
                        <td>
                            <input type="password" name="userPass" id="userPass"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">确认密码：</td>
                        <td>
                            <input type="password" name="rePass" id="rePass"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button onclick="ret()">返回</button>&nbsp;&nbsp;
                            <button onclick="res()">重置</button>&nbsp;&nbsp;
                            <button onclick="sub()">提交</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</form>
</body>


</html>
