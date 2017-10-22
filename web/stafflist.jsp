<%--
  Created by IntelliJ IDEA.
  User: mice
  Date: 2017/10/22
  Time: 上午11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="or.homework.vo.Staff"%>
<%@ page import="java.util.List"%>
<html>
<head>
    <%-- 一些css --%>
    <title>Title</title>
</head>
<body scroll="no">

<%--
<%
    List<Staff> staffList = (List<Staff>)request.getAttribute("staffList");
    //如果请求对象中图书列表为空，跳转到SearchBookServlet处理
    if (staffList == null) {
%>
    <jsp:forward page="SearchStaffServlet"></jsp:forward>


<%
    }
%>
--%>

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
    <tr style="height: 2%">
        <td>
            <table border="0" width="100%" align="center">
                <tr>
                    <td class="title_td">员工表</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr style="height: 96%">
        <td>
            <table width="70%">
                <tr>
                    <td width="10%" class="item_td">&nbsp;员工编号：</td>
                    <td class="input_td" style="width: 20%">
                        <input type="text" name="staffList" style="width: 100%"
                               class="input_input" size="30">
                    </td>
                    <td style="width: 1%">&nbsp;</td>
                    <td width="10%" class="item_id">&nbsp;员工姓名：</td>
                    <td width="15%" class="input_id">
                        <select name="staffID"
                                style="width: 100%" class="input_drop">

                        </select>
                    </td>
                    <td style="width: 1%">&nbsp;</td>
                    <td width="29%">
                        <button onclick="select()" id="btnSearch" name="btnSearch" style="width: 15%">查询</button>

                    </td>
                </tr>
            </table>
            <table border="0" width="100%" align="center">
                <tr style="height: 1px" class="">
                    <td class="title_td">员工列表&nbsp;</td>

                </tr>
            </table>
            <div style="position: absolute;left: 0px;bottom: 1px; z-index: 1000;" id="excel">
                <table style="width: 40%">

                    <tr>
                        <td style="cursor: hand;">
                            <%-- ???? --%>
                            <button onclick="showShop()" id="btnSave" name="btnSave"
                                    style="width: 100px">查看？？？</button>
                        </td>
                    </tr>
                </table>
            </div>

            <div class="list_div" style="height: 87%">
                <table border="0" align="left" cellspacing="0" class="list_table"
                       id="senfe" style="width: 99%">
                    <thead>

                        <tr>

                            <th width="5%">
                                <span style="font-weight: 400">编号</span>
                            </th>
                            <th width="28%"><span style="font-weight: 400">姓名</span> </th>
                            <th width="15%">
                                <span style="font-weight: 400">aaa</span>
                            </th>


                            <%-- 此处还可以再加 --%>

                        </tr>
                    </thead>

                    <tbody>
                    <%-- 使用JSP脚本循环显示 --%>

                    <%--<%
                        for(int i = 0 ; i < staffList.size() ; i++){
                            Staff staff = staffList.get(i);

                    %>--%>
                    <%--<tr>

                        <td align="center"><%i+1%></td>
                        <td><%=staff.getsName()%></td>
                        <td align="center"><%=staff.getsName() %></td>

                    </tr>--%>
                    </tbody>

                </table>
            </div>
        </td>
    </tr>
</table>


</body>
</html>
