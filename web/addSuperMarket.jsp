<%--
  Created by IntelliJ IDEA.
  User: LicolnLee
  Date: 10/24/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var name =document.getElementById("name").value;
            var manger =document.getElementById("manger").value;
            var smAdds =document.getElementById("smAdds").value;
            var username=document.getElementById("username").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (name==null|| name==""){
                alert("请填写超市名称");
                document.getElementById("name").focus();
            }else if (manger==null || manger==""){
                alert("请填写经理名称");
                document.getElementById("manger").focus();
            }
            else if (smAdds==null || smAdds==""){
                alert("请填写超市地址");
                document.getElementById("smAdds").focus();
            }
            else if(username==null || username==""){
                alert("请填写超市提交用户名");
                document.getElementById("userName").focus();
            }
            else if(userpass==null || userpass==""){
                alert("请填写超市提交登陆密码");
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
            document.getElementsByName("name").value=null;
            document.getElementsByName("manger").value=null;
            document.getElementsByName("smAdds").value=null;
            document.getElementsByName("userName").value=null;
            document.getElementsByName("userPass").value=null;
            document.getElementsByName("rePass").value=null;
        }
        function ret() {
            window.location="index.jsp";

    </script>
    <script type="text/javascript" src="js/year_month_day.js"></script>
    <title>AddSuperMarket</title>
</head>
<body class="login">
<form action="AddSuperMarketServlet" method="post" name="regist"></form>
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>新增超市信息</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="Add_content">
                    <tbody>
                    <tr>
                        <td class="Add_font">超市名称：</td>
                        <td>
                            <input type="text" name="name" id="name"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">经理名称：</td>
                        <td>
                            <input type="text" name="manager" id="manager"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">超市地址：</td>
                        <td>
                            <input type="text" name="smAdds" id="smAdds"  size="30" class="Add_input">
                        </td>
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
                            <button onclick="res()">重置</button>&nbsp;&nbsp;
                            <button onclick="sub()">提交</button>&nbsp;&nbsp;
                            <button onclick="ret()">返回</button>
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
