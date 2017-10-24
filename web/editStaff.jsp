<%@ page import="or.homework.vo.Staff" %>
<%@ page import="or.homework.dao.impl.StaffImpl" %>
<%@ page import="or.homework.vo.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="or.homework.dao.impl.LoginImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Mr.Joker
  Date: 2017/10/24
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
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
            var username = document.getElementById("userName").value;
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
            document.getElementById("sex").value=null;
            document.getElementById("userPhone").value=null;
            document.getElementById("userSalary").value=null;
            document.getElementById("userAddress").value=null;
            document.getElementById("userJob").value=null;
            document.getElementById("userName").value=null;
            document.getElementById("userPass").value=null;
            document.getElementById("rePass").value=null;
        }
        function ret() {
            window.location="staffList.jsp";
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
    Long sid=Long.valueOf(request.getParameter("sid"));
    Staff staff=new Staff();
    staff.setsID(sid);
    String sex;
    int a=0,b=0;
    StaffImpl staffImpl=new StaffImpl();
    Login login =new Login();
    login.setStaffid(sid);
    LoginImpl loginImpl=new LoginImpl();
    try{
        List<Staff> lists=staffImpl.select(staff);
        List<Login> lists2=loginImpl.select(login);
        if(lists!=null){
            staff=lists.get(0);
            sex=staff.getsSex();
            if(sex=="男"){
                a=1;
                b=0;
            }else {
                a=0;
                b=1;
            }
            login=lists2.get(0);
            pageContext.setAttribute("staff",staff);
            pageContext.setAttribute("login",login);
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
%>
<form action="UpdateStaffServlet" method="POST" name="regist">
    <div class="operation_page">
        <table class="Add">
            <tbody>
            <tr>
                <td class="Add_title">
                    <div>修改用户信息</div>
                </td>
            </tr>
            <tr>
                <td>
                    <table class="Add_content">
                        <tbody>
                        <tr>
                            <td class="Add_font">员工姓名：</td>
                            <td>
                                <input type="text" name="name" id="name"size="30" class="Add_input" value="<%=staff.getsName()%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">员工性别：</td>
                            <td>
                                <input type="radio" name="sex" id="sex" value="<%=a%>" checked="true">男
                                <input type="radio" name="sex" value="<%=b%>" >女
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">电话号码：</td>
                            <td>
                                <input type="text" name="userPhone" id="userPhone" size="30" class="Add_input" value="<%=staff.getsPhone()%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">月薪：</td>
                            <td>
                                <input type="text" name="userSalary" id="userSalary"  size="30" class="Add_input" value="<%=staff.getsSalary()%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">聘入日期：</td>
                            <td>
                                <%
                                    String date=(new SimpleDateFormat("yyyy年MM月dd日")).format(staff.getsDate());//
                                    SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");
                                    SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
                                    SimpleDateFormat sdf2= new SimpleDateFormat("dd");
                                    String str1 = sdf0.format(staff.getsDate());
                                    String str2 = sdf1.format(staff.getsDate());
                                    String str3 = sdf2.format(staff.getsDate());
                                %>
                                <input id="selYear" name="selYear" size="2" value="<%=str1%>">年
                                <input id="selMonth" name="selMonth"  size="2" value="<%=str2%>">月
                                <input id="selDay" name="selDay"  size="2" value="<%=str3%>">日
                                <input name="sid" value="<%=staff.getsID()%>" display="none">

                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">员工住址：</td>
                            <td>
                                <input type="text" name="userAddress"  id="userAddress" size="30" class="Add_input" value="<%=staff.getsAdds()%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">员工职位：</td>
                            <td>
                                <select name="userJob"  id="userJob" class="Add_input">
                                    <option value="<%=staff.getsProfessional()%>"><%=staff.getsProfessional()%></option>
                                    <option value="经理">经理</option>
                                    <option value="财务管理员">财务管理员</option>
                                    <option value="销售管理员">销售管理员</option>
                                    <option value="采购管理员">采购管理员</option>
                                    <option value="仓库管理员">仓库管理员</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font" colspan="2" text align="center">&nbsp;&nbsp;&nbsp;为该员工修改其登陆账户和密码：</td>
                        </tr>
                        <tr>
                            <td class="Add_font">用户名：</td>
                            <td>
                                <input type="text" name="userName" id="userName" size="30" class="Add_input" value="<%=login.getUsername()%>">
                            </td>
                        </tr>

                        <tr>
                            <td class="Add_font">用户密码：</td>
                            <td>
                                <input type="password" name="userPass" id="userPass" size="30" class="Add_input" value="<%=login.getPassword()%>">
                            </td>
                        </tr>
                        <tr>
                            <td class="Add_font">确认密码：</td>
                            <td>
                                <input type="password" name="rePass" id="rePass"  size="30" class="Add_input" value="<%=login.getPassword()%>">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button onclick="res()">重置</button>&nbsp;&nbsp;
                                <button onclick="sub()">提交</button>&nbsp;&nbsp;
                                <button onclick="ret()">返回</button>
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
