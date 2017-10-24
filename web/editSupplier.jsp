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
    <title>修改供应商信息</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var name =document.getElementById("name").value;
            var address =document.getElementById("address").value;
            var phone =document.getElementById("phone").value;
            var account =document.getElementById("account").value;
            var bank =document.getElementById("bank").value;
            var username=document.getElementById("username").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (name==null|| name==""){
                alert("请填写供应商名称");
                document.getElementById("name").focus();
            }else if (address==null || address==""){
                alert("请填写供应商地址");
                document.getElementById("address").focus();
            }
            else if (phone==null || phone==""){
                alert("请填写供应商电话");
                document.getElementById("phone").focus();
            }
            else if(account==null || account==""){
                alert("请填写供应商账号");
                document.getElementById("account").focus();
            }
            else if(bank==null || bank==""){
                alert("请选择供应商银行账号");
                document.getElementById("bank").focus();
            }
            else if(username==null || username==""){
                alert("请填写供应商提交用户名");
                document.getElementById("userName").focus();
            }
            else if(userpass==null || userpass==""){
                alert("请填写供应商提交登陆密码");
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
            document.getElementsByName("address").value=null;
            document.getElementsByName("phone").value=null;
            document.getElementsByName("account").value=null;
            document.getElementsByName("bank").value=null;
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
<form action="" method="" name="regist"></form>
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>修改供应商信息</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="Add_content">
                    <tbody>
                    <tr>
                        <td class="Add_font">供应商名称：</td>
                        <td>
                            <input type="text" name="name" id="name"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">供应商地址：</td>
                        <td>
                            <input type="text" name="address" id="address"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">供应商电话：</td>
                        <td>
                            <input type="text" name="phone" id="phone"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">供应商账号：</td>
                        <td>
                            <input type="text" name="account" id="account"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">供应商银行账号：</td>
                        <td>
                            <input type="text" name="bank"  id="bank"  size="30" class="Add_input">
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

