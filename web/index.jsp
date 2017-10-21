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
  <script>
    function loginClick() {
        //登陆用户信息判断
        var user=document.getElementById("username").value;
        var pass=document.getElementById("password").value;
        if(user=='Your name'){
            alert("请填写用户名！");
            document.getElementById("username").focus();
        }else if(pass =='******'){
            alert("请填写密码！");
            document.getElementById("password").focus();
        }else
            document.Login.submit();
    }

  </script>
</head>
<body class="login">
<%
  Cookies[] cookies=request.getCookies();
  String userName="";
  if(cookies!=null&&cookies.length>0){
  }
%>
<div class="login_m">
  <div class="login_logo"><img src="image/logo.png" width="196" height="46"></div>
  <div class="login_boder">
    <div class="login_padding">
      <h2>用户名</h2>
      <label>
        <input type="text" id="username" class="txt_input txt_input2"
               onfocus="if (value =='Your name'){value =''}"
               onblur="if (value ==''){value='Your name'}" value="Your name">
      </label>
      <h2>密码</h2>
      <label>
        <input type="password" id="password"  class="txt_input"
               onfocus=" if (value =='******'){value =''}"
               onblur="if (value ==''){value='******'}"  value="******">
      </label>
      <p class="forgot"><a href="javascript:void(0);">忘记密码?</a></p>
      <div class="rem_sub">
        <div class="rem_sub_l">
          <%--@declare id="checkbox"--%>
          <input type="checkbox" name="checkbox" id="save_me">
          <label for="checkbox">记住</label>
        </div>
        <label>
          <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" onclick="loginClick()">
        </label>
      </div>
    </div>
  </div><!--login_boder end-->
</div><!--login_m end-->
</body>
</html>
