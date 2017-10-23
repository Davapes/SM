<%--
  Created by IntelliJ IDEA.
  User: mice
  Date: 2017/10/23
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="or.homework.dao.impl.StaffImpl" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css路径">
            <script type="text/javascript" src="js路径"></script>
            <script type="text/javascript" src="js路径"></script>
            <script type="text/javascript" src="js路径"></script>
            <script language="JavaScript">
                function changPic(obj) {
                    var filename = obj.value;
                    var filetype = filename.split(".");
                    var filenumber = filetype.length-1;
                    if(filetype[filenumber].toUpperCase()!="JGP" && filetype[filenumber].toUpperCase()!="GIF"){
                        alert("请上传jpg或gif格式的图片");
                        obj.focus();
                        return false;
                    }else{
                        document.getElementsById("showPic").src=filename;
                    }
                }
                function ret() {
                    window.parent.frmMain.location="staffList.jsp";
                }
                function sub() {
                    doucument.form1.submit();
                }
                function fun_check_form() {

                }
                function ckeckIsfloat() {
                    var nc=event.keyCode;
                    if(nc<48||nc>57){
                        if(nc==46){
                            var s = document.form1.price.value;
                            for (var i = 0;i<s.length;i++){
                                if(s.charAt(i)=='.'){
                                    event.keyCode=0;
                                    return;
                                }
                            }
                        }else{
                            event.keyCode=0;
                            return;
                        }
                    }
                }
                function res() {
                    document.getElementsById("表的各个属性").value="";
                    //
                    //
                    //
                    document.getElementsById("delfile").innerHTML="<input name=pic type=file size=18 onChange='changePic(this)'>";
                    document.getElementsById("showPic").src="../路径";
                    document.getElementsById("desription").value="";

                }
            </script>
    <title>Title</title>
    <link herf="../css/mp.css" rel="stylesheet" type="text/css">
</head>
<body>
<%

        String QS=request.getParameter("QS");
        ServletContext ctx=this.getServletContext();
        String server=ctx.getInitParameter("server");
        String dbname=ctx.getInitParameter("dbname");
        String user=ctx.getInitParameter("user");
        String pwd=ctx.getInitParameter("pwd");
        GoodsDao dao=new GoodsDao();
        try{
                dao.getConn(server,dbname,user,pwd);
                Goods goods=dao.getGoodsByQS(QS);
                if(Goods!=null){
                        pageContext.setAttribute("Goods",goods);
                }
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }
%>
<form method="POST" name="forml" action="EditGoodsServlet">
<table style="height:100%;width:100%">
        <tr align="center" valign="middle">
<td>
    <TABLE style="height:200;width:492" cellSpacing=0
        cellPadding=0   border=0 align="center">
    <TBODY>
    <TR valign="middle">
        <td class="title_td" height=12 colspan="3">
                修改商品信息</td>
            </TR>
        <TR>
            <TD width="203"><img height=260 alt=""
            src="../image/Goodscovers/${Goods.pic}"
                width=202   style="cursor.pointer" id="showPic"></TD>
                <TD   style="background.image:
                      url(./images/login_Page/loginPage_03.jpg)"
                      height=120 width=497>
        <table style="width:100%">
                <tr>
                <td class="item_td" width="26%">商品名称:</td>
                <td class="input_td">
                        <input type="text" name="GoodsName"
                        value="${Goods.GoodsName}" style="width:100%"
                        class="input_input"     size="30"></td>
                    </tr>
                    <tr>
                        <td class="item_td" width="26%">QS:</td>
                        <td class="input_td"><select name="supplier"
                                style="width:100%" class="input_drop">
                        <option value="${Goods.supplierID}"><c:choose>
                                <c:when test="${Goods.supplierID==1}">
                                        雀巢
                                </c:when>
                                <c:when test="${Goods.supplierID==2}">
                                        可口可乐
                                </c:when>
                                <c:when test="${Goods.supplierID==3}">
                                        徐福记
                                </c:when>
                                </c:choose></option>
                            <option value="1"> 雀巢 </option>
                            <option value="2"> 可口可乐 </option>
                            <option value="3"> 徐福记 </option>
                        </select></td>
                        </tr>
                        <tr>
                            <td class="item_td" width="26%">价格:</td>
                            <td class="input_td">
                                    <input type="text" name="count"
                                    value="${Goods.count}"style="width=70%"
                                    class="input_input" size="30">(件/套)</td>
                        </tr>
                        <tr>
                            <td class="item_td" width="26%">商品封面:</td>
                            <td class="input_td" id="delFile">
                                    <input name="pic" value="${Goods.pic}"
                                    type="file" size="18"
                                    onChange="changPic(this)"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="items_td" width="26%" rowspan="3">
                                    商品简介:</td>
                            <td class="input_td" rowspan="3">
                                    <textarea       name="description" rows="12"
                                    style="width="100%" class="input_input">
                                    ${Goods.description }</textarea></td>
                        </tr>
                        </table></TD>
                        </TR>
                        </tr>
                            <td colspan="2" align="center">
                            <button onClick="ret()" style="width="20%">返回
                            </button>&nbsp;
                            <button onClick="res()" style="width="20%">重置
                            </button>&nbsp;
                            <button onClick="sub()" style="width="20%">提交
                            </button>
                            </td>
                        </tr>
                    </TBODY>
                </TABLE>
                </td>
            </tr>
</table>
</form>
</body>
</html>
