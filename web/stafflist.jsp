<%@ page import="or.homework.vo.Staff" %>
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
    <title>员工管理</title>
    <script language="JavaScript">
        function select() {
            document.search.submit();
        }
        function editStaff() {
            var allCheck=document.getElementsByName("userId");
            var num=0;
            var sid="";
            for(var i=0;i<allCheck.length;i++){
                if(allCheck[i].checked){
                    num++;
                    sid=allCheck[i].value;
                }
            }
            if(num==1){
//                window.parent.frmMain.location="editBook.jsp?sID="+sid;
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

        function deleteStaff() {
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

                    xmlHttp.open("Get","DeleteStaffServlet?del="+delstr);
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
        List<Staff> staffList=(List<Staff>)request.getAttribute("staffList");
        String staffname=(String)request.getAttribute("staffName");
        if(staffname==null)
            staffname="";
        String staffrole=(String)request.getAttribute("staffRole");
        if(staffrole==null)
            staffrole="";
        if(staffList==null) {
        }
    %>
    <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
        <tr style="height: 2%">
            <td>
                <table border="0" width="100%" align="center">
                    <tr>
                        <td class="title_td">员工一览</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr style="height: 96%">
            <td>
                <form method="post" name="search" action="SearchStaffServlet">
                    <table width="70%">
                        <tr>
                            <td width="10%" class="item_td">&nbsp;员工姓名：</td>
                            <td class="input_td" style="width: 20%">
                                <input type="text" name="staffName" style="width: 100%"
                                       class="input_input" size="30" value="<%=staffname%>">
                            </td>
                            <td style="width: 1%">&nbsp;</td>
                            <td width="10%" class="item_id">&nbsp;员工职称：</td>
                            <td width="15%" class="input_id">
                                <select name="staffRole"
                                        style="width: 100%" class="input_drop">
                                    <option value="<%=staffrole%>"><%=staffrole%></option>
                                    <option value="经理">经理</option>
                                    <option value="财务管理员">财务管理员</option>
                                    <option value="销售管理员">销售管理员</option>
                                    <option value="采购管理员">采购管理员</option>
                                    <option value="仓库管理员">仓库管理员</option>
                                </select>
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
                        <td class="title_td">员工列表&nbsp;</td>

                    </tr>
                </table>
                <div style="position: absolute;left: 0px;bottom: 1px; z-index: 1000;" id="excel">
                    <table style="width: 350px">
                        <tr>
                            <td style="cursor: hand;">
                                <button onclick="addStaff()"
                                        style="width: 100px">新增员工</button>&nbsp;&nbsp;
                                <button onclick="deleteStaff()"
                                        style="width: 100px">删除员工</button>&nbsp;&nbsp;
                                <button onclick="editStaff()"
                                        style="width: 100px">修改员工信息</button>
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
                                    <span style="font-weight: 400">序号</span>
                                </th>
                                <th width="7%">
                                    <span style="font-weight: 400">姓名</span>
                                </th>
                                <th width="7%">
                                    <span style="font-weight: 400">性别</span>
                                </th>
                                <th width="7%">
                                    <span style="font-weight: 400">工资</span>
                                </th>
                                <th width="7%">
                                    <span style="font-weight: 400">职称</span>
                                </th>
                                <th width="10%">
                                    <span style="font-weight: 400">电话</span>
                                </th>
                                <th width="15%">
                                    <span style="font-weight: 400">地址</span>
                                </th>
                                <th width="10%">
                                    <span style="font-weight: 400">入职日期</span>
                                </th>
                            </tr>
                        </thead>

                        <tbody>

                        <%
                            for(int i = 0 ; i < staffList.size() ; i++){
                                Staff staff = staffList.get(i);
                        %>
                        <tr>
                            <td align="center" width="1%">
                                <input type="checkbox" name="userId" value="<%=staff.getsID()%>">
                            </td>
                            <td align="center"><%=i+1%></td>
                            <td align="center"><%=staff.getsName()%></td>
                            <td align="center"><%=staff.getsSex() %></td>
                            <td align="center"><%=staff.getsSalary() %></td>
                            <td align="center"><%=staff.getsProfessional() %></td>
                            <td align="center"><%=staff.getsPhone() %></td>
                            <td align="center"><%=staff.getsAdds() %></td>
                            <td align="center"><%=staff.getsDate() %></td>
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
