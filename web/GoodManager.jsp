                <%@page language="java" contentType="text/html;charset=UTF-8"%>
                <%@page import="or.homework.vo.Commodity"%>
                <%@page import="java.util.*"%>
                <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
                <html>
                <head>
                <TITLE>网上超市后台管理系统</TITLE>
                <link type="text/css" rel="stylesheet" href="../css/mp.css">
                <link type="text/css" rel="stylesheet" href="../css/examples.css">
                <script type="text/javascript" src="../js/common.js"></script>
                <script type="text/javascript" src="../js/jquery.js"></script>
                <script type="text/javascript" src="../js/jquery-impromptu.js"></script>
                <script type="text/javascript" language="javascript"
                         src="../js/My97DatePicker/WdatePicker.js"></script>
                <script language="javascript">
                        function select(){
                                 document.search.submit();
                                 }
                                 function ckbSelect(sta,flag){
                                 for(var i=0;i<document.getElementsByName(flag).length;
                                 i++){
                                 document.getElementsByName(flag)[i].checked=sta;
                                 }
                                 }
                                 function addIt(){
                                 window.parent.frmMain.location="addCommodity.html";
                                 }
                </script>
                </head>
                <body scroll="no">
                <!--如果货物列表为空，跳到SearchCommodityServlet处理-->
                <c:if test="${CommodityList==null}">
                <jsp:forward page="SearchCommodityAdminServlet"></jsp:forward>
                </c:if>
                <table width="100%" height="100%"border="0" cellspacing="0" cellpadding="0">
                <tr style="height:2%">
                <td>    
                <table border="0" width="100%" align="center">
                <tr>
                <td class="title_td">商品一览</td>
                </tr>
                </table>
                </td>
                <tr style="height:96%">
                <td>
                <form method="POST"name="search"
                action="SearchCommodityAdminServlet">
                <table width="70%">
                <tr>
                <td width="10%"class="item_td">&nbsp;商品名称:</td>
                <td class="input_td"style="width:20%">
                <input type="text"      name="CommodityName" size="30" style="width:100%" class="input_input">
                </td>
                <td style="width:1%">&nbsp;</td>
                <td width="10%"class="item_id">&nbsp;商品公司:</td>
                <td width="15%" class="input_id">
                <select name="Processor"
                style="width:100%" class="input_drop">
                <option value=""></option>
                <option value="1">雀巢</option>
                <option value="2">可口可乐</option>
                <option value="3">徐福记</option>
                </select></td>
                <td style="width:1%">&nbsp;</td>
                <td width="29%">
                <button onClick="select()"id="gtnSearch"
                                name="gtnSearch" style="width:15%">
                                查询</button>
                        </td>
                </tr>
        </table>
        </form>
        <table border="0"width="100%" align="center">
                <tr style="height:1px" class="">
                        <td class="title_td">商品列表&nbsp;</td>
                </tr>
        </table>
        <div    style="position:absolute;left:0px;bottom:1px;
                z-index:1000;"id="excel">
        <table style="width:350px">
                <tr>
                        <td style="cursor:hand;">
                        <button style="width:100px"onClick="addIt()">
                        新增商品</button>   &nbsp;
                        <button style="width:100px"onClick="deleteIt()">
                        删除商品</button>   &nbsp;
                        <button style="width:100px"onClick="editIt()">
                        修改商品信息 </button>
                </td>
        </tr>
        </table>
        </div>
        <div class="List_div"style="height:87%">
        <table border="0"align="left"cellspacing="0"
                class="list_table"id="senfe"style='width:99%'>
                <thead>
                        <tr>
                                <th width="2%">
                                <input type="checkbox"name="checkAll"
                                        onClick="onclick=ckbSelect(this.checked,
                                        'userId'">
                                </th>
                                <th width="5%">
                                <span style="font-weight:400">序号</span></th>
                                <th width="28%">
                                <span style="font-weight:400">商品</span></th>
                                <th width="20%">
                                <span style="font-weight:400">商品公司</span></th>
                                <th width="16%">
                                <span style="font-weight:400">QS</span></th>
                                <th width="15%">
                                <span style="font-weight:400">
                                        价格（¥）<span></th>
                                <th width="">
                                <span style="font-weight:400">
                                        库存量(件/套)</span></th>
                                </tr>
                        </thead>
                        <tbody>
                                <c:forEach var="Commodity"items="${CommodityList}"
                                        varStatus="status">
                                        <tr>
                                                <td align="center"width="1%">
                                                <input type="checkbox"
                                                        name="userId"value="${Commodity.QS}"
                                                        class="input_radio"></td>
                                                <td align="center">${status.count}</td>
                                                <td>${Commodity.CommodityName}</td>
                                                <td align="center">
                                                <c:choose>
                                                <c:when test="${Commodity.publisherID==1}">
                                                                雀巢</c:when>
                                                <c:when test="${Commodity.publisherID==2}">
                                                                可口可乐</c:when>
                                                <c:when test="${Commodity.publisherID==3}">
                                                                徐福记</c:when>
                                                </c:choose></td>
                                                <td align="center">${Commodity.QS}</td>
                                                <td align="center">${Commodity.price}</td>
                                                <td align="center" nowrap="nowrap">
                                                ${Commodity.count}</td>
                                        </tr>
                                        </c:forEach>
                                </tbody>
                        </table>
                        </div>
                        </td>
                </tr>
        </table>
        </body>
        </html>
