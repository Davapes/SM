<%@ page import="or.homework.vo.Put" %>
<%@ page import="java.util.List" %>
<%@ page import="or.homework.vo.Put" %>
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
    <title>入库管理</title>
    <script language="JavaScript">
        function select() {
            document.search.submit();
        }
        function editPut() {
            var allCheck=document.getElementsByName("PutId");
            var num=0;
            var Putid="";
            for(var i=0;i<allCheck.length;i++){
                if(allCheck[i].checked){
                    num++;
                    Putid=allCheck[i].value;
                }
            }
            if(num==1){
//                window.parent.frmMain.location="editBook.jsp?Putid="+Putid;
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

        function deletePut() {
            var allCheck=document.getElementsByName("PutId");
            var num=0;
            var delstr="";
            for(var i=0;i<allCheck.length;i++){
                if(allCheck[i].checked){
                    num++;
                    delstr+=allCheck[i].value+",";
                }
            }
            if(num>0){
                if(window.confirm("您确定要删除选中的入库表信息？")){
                    //创建一个XMLHttpRequest对象
                    CreateXMLHttpRequest();
                    xmlHttp.onreadystatechange=processor;

                    xmlHttp.open("Get","DeletePutservlet?del="+delstr);
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
                        var allCheck=document.getElementsByName("PutId");
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
    List<Put> putList=(List<Put>)request.getAttribute("PutList");
    String putdate=(String)request.getAttribute("putdate");
    if(putdate==null)
        putdate="";
//    String putaddress=(String)request.getAttribute("putaddress");
//    if(putaddress==null)
//        putaddress="";
    if(putList==null) {
    }
%>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
    <tr style="height: 2%">
        <td>
            <table border="0" width="100%" align="center">
                <tr>
                    <td class="title_td">入库一览</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr style="height: 96%">
        <td>
            <form method="post" name="search" action="SearchPutServlet">
                <table width="70%">
                    <tr>
                        <td width="10%" class="item_td">&nbsp;入库日期：</td>
                        <td class="input_td" style="width: 20%">
                            <input type="text" name="putdate" style="width: 100%"
                                   class="input_input" size="30" value="<%=putdate%>">
                        </td>
                        <%--<td style="width: 1%">&nbsp;</td>--%>
                        <%--<td width="10%" class="item_id">&nbsp;仓库地址：</td>--%>
                        <%--<td width="15%" class="input_id">--%>
                            <%--<select name="putaddress"--%>
                                    <%--style="width: 100%" class="input_drop">--%>
                                <%--<option value="<%=putaddress%>"><%=putaddress%></option>--%>
                                <%--&lt;%&ndash;<option value="经理">经理</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="财务管理员">财务管理员</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="销售管理员">销售管理员</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="采购管理员">采购管理员</option>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="仓库管理员">仓库管理员</option>&ndash;%&gt;--%>
                            <%--</select>--%>
                        </td>
                        <td style="width: 1%">&nbsp;</td>
                        <td width="29%">
                            <button onclick="select()" id="btnSearch" name="btnSearch" style="width: 15%">查询</button>
                        </td>
                    </tr>
                </table>
            </form>
            <table border="0" width="100%" align="center">
                <tr style="height: 1px" class="">
                    <td class="title_td">入库列表&nbsp;</td>

                </tr>
            </table>
            <div style="position: absolute;left: 0px;bottom: 1px; z-index: 1000;" id="excel">
                <table style="width: 350px">
                    <tr>
                        <td style="cursor: hand;">
                            <button onclick="addPut()"
                                    style="width: 100px">新增入库</button>&nbsp;&nbsp;
                            <button onclick="deletePut()"
                                    style="width: 100px">删除入库</button>&nbsp;&nbsp;
                            <button onclick="editPut()"
                                    style="width: 100px">修改入库信息</button>
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
                            <input type="checkbox" name="checkAll" onclick="onclick=ckbSelect(this.checkbox,'putdate')">
                        </th>
                        <th width="5%">
                            <span style="font-weight: 400">入库时间</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">入库编号</span>
                        </th>
                        <th width="7%">
                            <span style="font-weight: 400">入库数量</span>
                        </th>
                        <%--<th width="7%">--%>
                            <%--<span style="font-weight: 400">商品编号</span>--%>
                        <%--</th>--%>
                        <%--<th width="7%">--%>
                            <%--<span style="font-weight: 400">采购编号</span>--%>
                        <%--</th>--%>
                        <%--<th width="10%">--%>
                            <%--<span style="font-weight: 400">仓库编号</span>--%>
                        <%--</th>--%>
                        <%--<th width="15%">--%>
                        <%--<span style="font-weight: 400">供应商</span>--%>
                        <%--</th>--%>
                        <%--<th width="10%">--%>
                        <%--<span style="font-weight: 400"></span>--%>
                        <%--</th>--%>
                    </tr>
                    </thead>

                    <tbody>

                    <%
                        for(int i = 0 ; i < putList.size() ; i++){
                            Put put = putList.get(i);
                    %>
                    <tr>
                        <td align="center" width="1%">
                            <input type="checkbox" name="userId" value="<%=put.getPutrq()%>">
                        </td>
                        <td align="center"><%=i+1%></td>
                        <td align="center"><%=put.getPutID()%></td>
                        <td align="center"><%=put.getPutnum() %></td>
                        <%--<td align="center"><%=put.getPutAddress() %></td>--%>
                        <%--<td align="center"><%=put.getCapacity() %></td>--%>
                        <%--<td align="center"><%=put.getLeftCapacity() %></td>--%>
                        <%--<td align="center"><%=put.getsAdds() %></td>--%>
                        <%--<td align="center"><%=put.getsDate() %></td>--%>
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
