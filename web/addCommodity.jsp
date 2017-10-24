<%--
  Created by IntelliJ IDEA.
  User: LicolnLee
  Date: 10/24/2017
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head> <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var name =document.getElementById("name").value;
            var units =document.getElementById("units").value;
            var origin =document.getElementById("origin").value;
            var brand =document.getElementById("brand").value;
            var price =document.getElementById("price").value;
            var purchaseprice =document.getElementById("purchaseprice").value;
            var purchaseyear = document.getElementById("purchaseYear").value;
            var purchasemonth = document.getElementById("purchaseMonth").value;
            var purchaseday = document.getElementById("purchaseDay").value;
            var supplierid = document.getElementById("suppierid").value;
            var warranty = document.getElementById("warranty").value;
            var warehouseid = document.getElementById("warehouseid").value;
            var username=document.getElementById("username").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (name==null|| name==""){
                alert("请填写商品名称");
                document.getElementById("name").focus();
            }else if (units==null || units==""){
                alert("请填写商品单位");
                document.getElementById("units").focus();
            }
            else if (origin==null || origin==""){
                alert("请填写商品产地");
                document.getElementById("origin").focus();
            }
            else if(brand==null || brand==""){
                alert("请填写商品商标");
                document.getElementById("brand").focus();
            }
            else if(price==null || price==""){
                alert("请选择商品价格");
                document.getElementById("price").focus();
            }
            else if(purchaseprice==null || purchaseprice==""){
                alert("请选择商品进价");
                document.getElementById("purchaseprice").focus();
            }
            else if(supplierid==null || supplierid==""){
                alert("请选择商品供应商ID");
                document.getElementById("supplierid").focus();
            }
            else if(warranty==null || warranty==""){
                alert("请选择商品保质期");
                document.getElementById("warranty").focus();
            }
            else if(warehouseid==null || warehouseid==""){
                alert("请选择商品仓库ID");
                document.getElementById("warehouseid").focus();
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
            document.getElementsByName("name").value=null;
            document.getElementsByName("units").value=null;
            document.getElementsByName("origin").value=null;
            document.getElementsByName("brand").value=null;
            document.getElementsByName("price").value=null;
            document.getElementsByName("purchaseprice").value=null;
            document.getElementsByName("supplierid").value=null;
            document.getElementsByName("warranty").value=null;
            document.getElementsByName("warehouseid").value=null;
            document.getElementsByName("userName").value=null;
            document.getElementsByName("userPass").value=null;
            document.getElementsByName("rePass").value=null;
        }

    </script>
    <script type="text/javascript" src="js/year_month_day.js"></script>
    <title>AddCommodity</title>
</head>
<body class="login">
<form action="AddCommodityServlet" method="post" name="regist"></form>
<div class="operation_page">
    <table class="Add">
        <tbody>
        <tr>
            <td class="Add_title">
                <div>新增商品信息</div>
            </td>
        </tr>
        <tr>
            <td>
                <table class="Add_content">
                    <tbody>
                    <tr>
                        <td class="Add_font">商品名称：</td>
                        <td>
                            <input type="text" name="name" id="name" value size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品单位：</td>
                        <td>
                            <input type="radio" name="units" id="units" value="1" checked="true">斤
                            <input type="radio" name="units1" value="0" >两
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品产地：</td>
                        <td>
                            <input type="text" name="origin" id="origin" value size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品商标：</td>
                        <td>
                            <input type="text" name="brand" id="brand" value size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品采购日期：</td>
                        <td>
                            <select id="purchaseYear" name="purchaseYear"></select>
                            <select id="purchaseMonth" name="purchaseMonth"></select>
                            <select id="purchaseDay" name="purchaseDay"></select>
                            <script type="text/javascript">
                                var purchaseYear = window.document.getElementById("purchaseYear");
                                var purchaseMonth = window.document.getElementById("purchaseMonth");
                                var purchaseDay = window.document.getElementById("purchaseDay");
                                new DateSelector(purchaseYear, purchaseMonth, purchaseDay, 2017, 10, 25);
                                var dt = new Date(2017, 10, 25);
                                new DateSelector(purchaseYear, purchaseMonth ,purchaseDay, dt);
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品价格：</td>
                        <td>
                            <input type="text" name="price"  id="price" value size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品进价：</td>
                        <td>
                            <input type="text" name="purchaseprice"  id="purchaseprice"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品进价：</td>
                        <td>
                            <input type="text" name="purchaseprice"  id="purchaseprice"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品供应商ID：</td>
                        <td>
                            <input type="text" name="supplierid"  id="supplierid"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品保质期：</td>
                        <td>
                            <input type="text" name="warranty"  id="warranty"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font">商品仓库ID：</td>
                        <td>
                            <input type="text" name="warehouseid"  id="warehouseid"  size="30" class="Add_input">
                        </td>
                    </tr>
                    <tr>
                        <td class="Add_font" colspan="2" text align="center">&nbsp;&nbsp;&nbsp;请为该商品设置其登陆账户和密码：</td>
                    </tr>
                    <tr>
                        <td class="Add_font">用户提交名：</td>
                        <td>
                            <input type="text" name="userName" id="userName" value size="30" class="Add_input">
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
