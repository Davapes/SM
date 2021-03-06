<%--
  Created by IntelliJ IDEA.
  User: LicolnLee
  Date: 10/24/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%><%@ page import="or.homework.vo.Procurement" %>
<%@ page import="or.homework.dao.impl.ProcurementImpl" %>
<%@ page import="or.homework.vo.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="or.homework.dao.impl.LoginImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改采购表单信息</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var commodityid =document.getElementById("commodityid").value;
            var purchaseid =document.getElementById("purchaseid").value;
            var pnum =document.getElementById("pnum").value;
            var pje =document.getElementById("pje").value;
            var username=document.getElementById("username").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (commodityid==null|| commodityid==""){
                alert("请填写商品ID");
                document.getElementById("commodityid").focus();
            }else if (purchaseid==null || purchaseid==""){
                alert("请填写采购编号");
                document.getElementById("purchaseid").focus();
            }
            else if (pnum==null || pnum==""){
                alert("请填写采购数量");
                document.getElementById("pnum").focus();
            }
            else if(pje==null || pje==""){
                alert("请填写采购金额");
                document.getElementById("pje").focus();
            }
            else if(username==null || username==""){
                alert("请填写商品提交用户名");
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
            document.getElementsByName("purchaseid").value=null;
            document.getElementsByName("pnum").value=null;
            document.getElementsByName("pje").value=null;
            document.getElementsByName("userName").value=null;
            document.getElementsByName("userPass").value=null;
            document.getElementsByName("rePass").value=null;
        }
        function ret() {
            window.location="ProcurementList.jsp";
        }

    </script>
    <script type="text/javascript" src="js/year_month_day.js"></script>
    <script type="text/javascript">
        var selYear = window.document.getElementById("selYear");
        var selMonth = window.document.getElementById("selMonth");
        var selDay = window.document.getElementById("selDay");
        new DateSelector(selYear, selMonth, selDay, 2017, 10, 25);
        var dt = new Date(2017, 10, 25);
        new DateSelector(selYear, selMonth ,selDay, dt);
    </script>
</head>
<body class="login">
<form action="UpdateProcurementServlet" method="POST" name="regist">
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>x修改采购信息</div>
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
                        <td class="Add_font">采购编号：</td>
                        <td>
                            <input type="text" name="purchaseid" id="purchaseid"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">采购数量：</td>
                        <td>
                            <input type="text" name="pnum" id="pnum"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">采购金额：</td>
                        <td>
                            <input type="text" name="pje" id="pje"  size="30" class="Add_input">
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
