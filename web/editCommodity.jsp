<%--
  Created by IntelliJ IDEA.
  User: LicolnLee
  Date: 10/24/2017
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="or.homework.vo.Commodity" %>
<%@ page import="or.homework.dao.impl.CommodityImpl" %>
<%@ page import="or.homework.vo.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="or.homework.dao.impl.LoginImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="or.homework.vo.Commodity" %>
<%@ page import="or.homework.dao.impl.CommodityImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script language="JavaScript">
        function sub() {
            var name =document.getElementById("name").value;
            var units =document.getElementById("units").value;
            var origin =document.getElementById("origin").value;
            var brand =document.getElementById("brand").value;
            var price =document.getElementById("price").value;
            var purchaseprice =document.getElementById("purchaseprice").value;
            var supplierid = document.getElementById("suppierid").value;
            var warranty = document.getElementById("warranty").value;
            var warehouseid = document.getElementById("warehouseid").value;
            var year = document.getElementById("selYear").value;
            var month = document.getElementById("selMonth").value;
            var day = document.getElementById("selDay").value;
            var username = document.getElementById("userName").value;
            var userpass = document.getElementById("userPass").value;
            var repass = document.getElementById("rePass").value;
            if (name==null|| name==""){
                alert("请填写商品名称");
                document.getElementById("name").focus();
            }else if (origin==null || origin==""){
                alert("请填写商品单位");
                document.getElementById("origin").focus();
            }
            else if (brand==null || brand==""){
                alert("请填写商品品牌");
                document.getElementById("brand").focus();
            }
            else if(price==null || price==""){
                alert("请填写商品价格");
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
                alert("请填写员工商品名");
                document.getElementById("userName").focus();
            }
            else if(userpass==null || userpass==""){
                alert("请填写员工登陆密码");
                document.getElementById("userPass").focus();
            }
            else if(repass==null || repass==""){
                alert("请确认密码");
                document.getElementById("rePass").focus();
            }
            else if(userpass!=repass){
                alert("确认密码不相符!");
                document.getElementById("rePass").value=null;
                document.getElementById("rePass").focus();
            }
            else{
                document.regist.submit;
            }
        }
        function res() {
            document.getElementById("name").value=null;
            document.getElementById("units").value=null;
            document.getElementById("origin").value=null;
            document.getElementById("brand").value=null;
            document.getElementById("price").value=null;
            document.getElementById("purchaseprice").value=null;
            document.getElementsByName("supplierid").value=null;
            document.getElementsByName("warranty").value=null;
            document.getElementsByName("warehouseid").value=null;
            document.getElementById("userName").value=null;
            document.getElementById("userPass").value=null;
            document.getElementById("rePass").value=null;
        }
        function ret() {
            window.location="commodityList.jsp";
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
<%
    Long cid=Long.valueOf(request.getParameter("cid"));
    Commodity commodity=new Commodity();
    commodity.setcID(cid);
    CommodityImpl commodityImpl=new CommodityImpl();
    try{
        List<Commodity> lists=commodityImpl.select(commodity);
        if(lists!=null){
            commodity=lists.get(0);
            pageContext.setAttribute("commodity",commodity);
            pageContext.setAttribute("login",login);
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
%>
<form action="UpdateCommodityServlet" method="POST" name="regist">
    <div class="operation_page">
        <table class="Add">
            <tbody>
            <tr>
                <td class="Add_title">
                    <div>修改商品信息</div>
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
                            <td class="Add_font" colspan="2" text align="center">&nbsp;&nbsp;&nbsp;为该员工修改其登陆账户和密码：</td>
                        </tr>
                        <tr>
                            <td class="Add_font">商品名：</td>
                            <td>
                                <input type="text" name="userName" id="userName"  size="30" class="Add_input">
                            </td>
                        </tr>

                        <tr>
                            <td class="Add_font">商品密码：</td>
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
