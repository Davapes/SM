<%@ page import="or.homework.vo.Exit" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.Joker
  Date: 2017/10/22
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出库管理</title>
    <script language="JavaScript">
        function select() {
            document.search.submit();
        }
        function editExit() {
            var allCheck=document.getElementsByName("userId");
            var num=0;
            var EXITID="";
            for(var i=0;i<allCheck.length;i++){
                if(allCheck[i].checked){
                    num++;
                    EXITID=allCheck[i].value;
                }
            }
            if(num==1){
//                window.parent.frmMain.location="editBook.jsp?EXITID="+EXITID;
            }else if(num==0){
                alert("没有选中信息！");
                return;
            }else {
                alert("请选中单条信息进行修改！");
                return;
            }
        }
        var xmlHttp;
        //该函数用于创建一个XMLHttpREquest的对象
        function CreateXMLHttpRequest() {
            if (window.ActiveXObject){
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }else if (window.XMLHttpRequest){
                xmlHttp=new XMLHttpRequest();
            }
        }
        //这是一个通过AJAX异步删除的方法

        function deleteExit() {
            var allCheck=document.getElementsByName("userId");
            var num=0;
            var delstr="";
            for(var i=0;i<allCheck.length;i++){
                if(allCheck[i].checked){
                    num++;
                    delstr+=allCheck[i].value+",";
                }
            }
            if(num>0){
                if(window.confirm("您确定要删除选中的员工信息？")){
                    //创建一个XMLHttpRequest对象
                    CreateXMLHttpRequest();
                    xmlHttp.onreadystatechange=processor;

                    xmlHttp.open("Get","DeleteexitServlet?del="+delstr);
                    //发送请求
                    xmlHttp.send();
                }
            }else{
                alert("没有选中信息！");
                return;
            }
        }
        //处理从服务器返回的信息
        function processor() {
            if(xmlHttp.readyState ==4){//如果响应完成
                if(xmlHttp.status ==200){//如果返回成功
                    //取出服务器返回的响应文本信息
                    var flag=xmlHttp.responseText;
                    //服务器成功删除数据库中的数据
                    if(flag.indexOf("ture")!=-1){
                        //删除页面中的信息
                        var allCheck=document.getElementsByName("userId");
                        for(var i=0;i<allCheck.length;i++){
                            if(allCheck[i].checked){
                                var chTr=allCheck[i].parentNode.parentNode;
                                chTr.remove(true);
                                i--;
                            }
                        }
                    }else{
                        alert("删除失败！");
                    }
                }
            }
        }
    </script>
</head>
<body>
<%
    List<Exit> exitList=(List<Exit>)request.getAttribute("exitList");
    String exitname=(String)request.getAttribute("exitName");
    if(exitname==null)
        exitname="";
    String exitdate=(String)request.getAttribute("ExitDate");
    if(exitdate==null)
        exitdate="";
    if(exitList==null) {
    }
%>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
    <tr style="height: 2%">
        <td>
            <table border="0" width="100%" align="center">
                <tr>
                    <td class="title_td">出库一览</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr style="height: 96%">
        <td>
            <form method="post" name="search" action="SearchExitServlet">
                <table width="70%">
                    <tr>
                        <td width="10%" class="item_td">&nbsp;出库编号：</td>
                        <td class="input_td" style="width: 20%">
                            <input type="text" name="exitName" style="width: 100%"
                                   class="input_input" size="30" value="<%=exitname%>">
                        </td>
                        <td style="width: 1%">&nbsp;</td>
                        <td width="10%" class="item_id">&nbsp;出库日期：</td>
                        <td width="15%" class="input_id">
                            <select name="exitdate"
                                    style="width: 100%" class="input_drop">
                                <%--<option value="<%=exitdate%>"><%=exitdate%></option>--%>
                                <%--<option value="经理">经理</option>--%>
                                <%--<option value="财务管理员">财务管理员</option>--%>
                                <%--<option value="销售管理员">销售管理员</option>--%>
                                <%--<option value="采购管理员">采购管理员</option>--%>
                                <%--<option value="仓库管理员">仓库管理员</option>--%>
                            </select>
                        </td>
                        <td style="width: 1%">&nbsp;</td>
                        <td width="29%">
                            <button onclick="select()" id="btnSearch" name="btnSearch" style="width: 15%">出库查询</button>
                        </td>
                    </tr>
                </table>
            </form>
            <table border="0" width="100%" align="center">
                <tr style="height: 1px" class="">
                    <td class="title_td">出库记录&nbsp;</td>

                </tr>
            </table>
            <div style="position: absolute;left: 0px;bottom: 1px; z-index: 1000;" id="excel">
                <table style="width: 350px">
                    <tr>
                        <td style="cursor: hand;">
                            <button onclick="addexit()"
                                    style="width: 100px">新增出库记录</button>&nbsp;&nbsp;
                            <button onclick="deleteexit()"
                                    style="width: 100px">删除出库记录</button>&nbsp;&nbsp;
                            <button onclick="editexit()"
                                    style="width: 100px">修改出库记录</button>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="list_div" style="height: 87%">
                <table border="0" align="left" cellspacing="0" class="list_table"
                       id="senfe" style="width: 99%">
                    <thead>
                    <tr>
                        <th width="2%">
                            <input type="checkbox" name="checkAll" onclick="onclick=ckbSelect(this.checkbox,'userid')">
                        </th>
                        <th width="5%">
                            <span style="font-weight: 400">出库编号</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">员工编号</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">采购员编号</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">仓库编号</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">出库日期</span>
                        </th>
                        <th width="10%">
                            <span style="font-weight: 400">出库数量</span>
                        </th>
                        <%--<th width="15%">--%>
                            <%--<span style="font-weight: 400">地址</span>--%>
                        <%--</th>--%>
                        <%--<th width="10%">--%>
                            <%--<span style="font-weight: 400">入职日期</span>--%>
                        <%--</th>--%>
                    </tr>
                    </thead>

                    <tbody>

                    <%
                        for(int i = 0 ; i < exitList.size() ; i++){
                            Exit exit = exitList.get(i);
                    %>
                    <tr>
                        <td align="center" width="1%">
                            <input type="checkbox" name="exitID" value="<%=exit.getExitID()%>">
                        </td>
                        <td align="center"><%=i+1%></td>
                        <td align="center"><%=exit.getStaffid()%></td>
                        <%--<td align="center"><%=exit.getNum() %></td>--%>
                        <%--<td align="center"><%=exit.getWhnum() %></td>--%>
                        <td align="center"><%=exit.getSnumation() %></td>
                        <td align="center"><%=exit.getWarehouseid() %></td>
                        <td align="center"><%=exit.getExitDate() %></td>
                        <td align="center"><%=exit.getExitNum() %></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </td>
    </tr>
</table>

</body>
</html>
