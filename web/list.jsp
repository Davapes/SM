<%--
  Created by IntelliJ IDEA.
  User: mice
  Date: 2017/10/21
  Time: 下午8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<%@ page 此处应有所列表的类 xxx %>
--%>
<%@ page import="java.util.List"%>
<html>
<head>
    <%-- 一些css --%>
    <title>Title</title>
</head>



<body scroll="no">
<%
    List<xxx> xxxList = (List<xxx>)request.getAttribute("xxxList");
    //如果请求对象中图书列表为空，跳转到SearchxxxServlet进行处理
    if(xxxList == null) {
        <jsp:forward page = "SearchxxxServlet" ></jsp:forward >
    }

%>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
        </table>
    <tr style = "height;2%">
    <td>
        <table border="0" width="100%" align=""

</body>
</html>
