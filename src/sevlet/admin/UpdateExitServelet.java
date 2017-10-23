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

public class UpdateExitServelet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private Long exitID;
        private Long staffid;
        private Long snumation;
        private Long commodityid;
        private Long warehouseid;
        private Date exitDate;
        private Long exitNum;
         */




        Long staffid = Long.valueOf(request.getParameter("staffID"));
        Long snumation = Long.valueOf(request.getParameter("Snumation"));
        Long commodityid = Long.valueOf(request.getParameter("commodityId"));
        Long warehouseid = Long.valueOf(request.getParameter("warehouseID"));
        Long exitnum = Long.valueOf(request.getParameter("exitNum"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date exitDate = null;
        try {
            exitDate = sdf.parse(request.getParameter("exitDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


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
            exitImpl.update(exit);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
