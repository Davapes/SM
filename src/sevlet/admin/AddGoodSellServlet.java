package sevlet.admin;

import or.homework.dao.impl.CommodityImpl;
import or.homework.dao.impl.ExitImpl;
import or.homework.dao.impl.LoginImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Exit;
import or.homework.vo.Login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddGoodSellServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charst=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private Long gsID;
        private Long commodityid;
        private Long merchandisingid;
        private Long gsNum;//商品数量
        private Long gsje;//商品金额
        private Long gsylje;//商品盈利
         */

        Long gsid = Long.valueOf(request.getParameter("gsID"));
        Long commodityid = Long.valueOf(request.getParameter("commodityID"));
        Long merchandisingid = Long.valueOf(request.getParameter("merchandisingID"));
        Long gsnum = Long.valueOf(request.getParameter("gsNum"));
        Long gsmoney = Long.valueOf(request.getParameter("gsMoney");
        Long gsylje


        ExitImpl exitImpl = new ExitImpl();
        Exit exit = new Exit();

        exit.setStaffid(staffid);
        exit.setSnumation(snumation);
        exit.setCommodityid(commodityid);
        exit.setWarehouseid(warehouseid);
        exit.setExitNum(exitnum);
        exit.setExitDate(exitDate);

        try{

            //向表中插入一条记录
            exitImpl.add(exit);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
