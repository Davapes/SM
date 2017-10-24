<%--
  Created by IntelliJ IDEA.
  User: Mr.Joker
  Date: 2017/10/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var name =document.getElementById("name").value;
            var sex =document.getElementById("sex").value;
            var phone =document.getElementById("userPhone").value;
            var salary =document.getElementById("userSalary").value;
            var address =document.getElementById("userAddress").value;
            var job =document.getElementById("userJob").value;
            var year = document.getElementById("selYear").value;
            var month = document.getElementById("selMonth").value;
            var day = document.getElementById("selDay").value;
            var userame = document.getElementById("userName").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (name==null|| name==""){
                alert("请填写员工姓名");
                document.getElementById("name").focus();
            }else if (phone==null || phone==""){
                alert("请填写员工联系方式");
                document.getElementById("userPhone").focus();
            }
            else if (salary==null || salary==""){
                alert("请填写员工工资");
                document.getElementById("userSalary").focus();
            }
            else if(address==null || address==""){
                alert("请填写员工地址");
                document.getElementById("userAddress").focus();
            }
            else if(job==null || job==""){
                alert("请选择员工职称");
                document.getElementById("userJob").focus();
            }
            else if(username==null || username==""){
                alert("请填写员工用户名");
                document.getElementById("userName").focus();
            }
            else if(userpass==null || userpass==""){
                alert("请填写员工登陆密码");
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
            document.getElementsByName("sex").value=null;
            document.getElementsByName("userPhone").value=null;
            document.getElementsByName("userSalary").value=null;
            document.getElementsByName("userAddress").value=null;
            document.getElementsByName("userJob").value=null;
            document.getElementsByName("userName").value=null;
            document.getElementsByName("userPass").value=null;
            document.getElementsByName("rePass").value=null;
        }

    </script>
    <script type="text/javascript" src="js/year_month_day.js"></script>
    <title>AddUser</title>
</head>
<body class="login">
<form action="AddStaffServlet" method="post" name="regist"></form>
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>新增用户信息</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="Add_content">
                    <tbody>
                    <tr>
                        <td class="Add_font">员工姓名：</td>
                        <td>
                            <input type="text" name="name" id="name"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">员工性别：</td>
                        <td>
                            <input type="radio" name="sex" id="sex" value="1" checked="true">男
                            <input type="radio" name="sex1" value="0" >女
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">电话号码：</td>
                        <td>
                            <input type="text" name="userPhone" id="userPhone"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">月薪：</td>
                        <td>
                            <input type="text" name="userSalary" id="userSalary"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">聘入日期：</td>
                        <td>
                            <select id="selYear" name="selYear"></select>
                            <select id="selMonth" name="selMonth"></select>
                            <select id="selDay" name="selDay"></select>
                            <script type="text/javascript">
                                var selYear = window.document.getElementById("selYear");
                                var selMonth = window.document.getElementById("selMonth");
                                var selDay = window.document.getElementById("selDay");
                                new DateSelector(selYear, selMonth, selDay, 2017, 10, 25);
                                var dt = new Date(2017, 10, 25);
                                new DateSelector(selYear, selMonth ,selDay, dt);
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">员工住址：</td>
                        <td>
                            <input type="text" name="userAddress"  id="userAddress"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">员工职位：</td>
                        <td>
                            <select name="userJob"  id="userJob" class="Add_input">
                                <option value=""></option>
                                <option value="经理">经理</option>
                                <option value="财务管理员">财务管理员</option>
                                <option value="销售管理员">销售管理员</option>
                                <option value="采购管理员">采购管理员</option>
                                <option value="仓库管理员">仓库管理员</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font" colspan="2" text align="center">&nbsp;&nbsp;&nbsp;请为该员工设置其登陆账户和密码：</td>
                    </tr>
                    <tr>
                        <td class="Add_font">用户名：</td>
                        <td>
                            <input type="text" name="userName" id="userName"  size="30" class="Add_input">
                        </td>
                    </tr>

                    <tr>
                        <td class="Add_font">用户密码：</td>
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
                            <button onclick="res()">重置</button>
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


</body>
</html>
