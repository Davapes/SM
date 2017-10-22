<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/19
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WoShop管理系统</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <script LANGUAGE="JavaScript">
        function loginClick() {
            //登陆用户信息判断
            var user=document.getElementById("username").value;
            var pass=document.getElementById("password").value;
            if(user==""){
                alert("请填写用户名！");
                document.getElementById("username").focus();
            }else if(pass ==""){
                alert("请填写密码！");
                document.getElementById("password").focus();
            }else
                document.Login.submit();
        }
        function res() {
            document.getElementById("username").value=null;
            document.getElementById("password").value=null;
        }
    </script>
<body class="login">
</head>
    <form method="post" name="Login" action="LoginServlet">
        <%
            Cookie[] cookies=request.getCookies();
            String userName="";
            if(cookies!=null&&cookies.length>0){
                for(int i=0;i<cookies.length;i++)
                    if(cookies[i].getName().equals("userName")){
                        userName=cookies[i].getValue();
                    }
            }
        %>

        <div class="login_m">
            <div class="login_logo"><img src="image/logo.png" width="196" height="46"></div>
            <div class="login_boder">
                <div class="login_padding">
                    <h2>用户名</h2>
                    <label>
                        <input type="text" id="username" name="username" class="txt_input txt_input2"
                                placeholder="Your Name">
                    </label>
                    <h2>密码</h2>
                    <label>
                        <input type="password" id="password" name="password"   class="txt_input"
                               placeholder="Your Password">
                    </label>
                    <div class="rem_sub">
                        <div class="rem_sub_l">
                        </div>
                        <label>
                            <input type="button" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" onclick="loginClick()">
                            <input type="button" class="sub_buttons" name="button" id="buttons" value="重置" style="opacity: 0.7;" onclick="res()">
                        </label>
                    </div>
                </div>
            </div><!--login_boder end-->
        </div><!--login_m end-->
    </form>
</body>
</html>
