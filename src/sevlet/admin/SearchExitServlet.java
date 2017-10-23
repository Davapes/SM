package sevlet.admin;

import or.homework.dao.impl.ExitImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Exit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SearchExitServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long exitid = Long.valueOf(request.getParameter("exitID"));//出库批次
        Long staffid = Long.valueOf(request.getParameter("staffID"));//管理员编号
        Long warehouseid = Long.valueOf(request.getParameter("warehouseID"));//仓库编号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date exitdate = null;
        try {
            exitdate = sdf.parse(request.getParameter("exitDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //ConnectJDBC db = new ConnectJDBC();
        ExitImpl stfImlp = new ExitImpl();
        Exit exit = new Exit();
        List<Exit> exitList = null;

        exit.setExitID(exitid);
        exit.setStaffid(staffid);
        exit.setWarehouseid(warehouseid);
        exit.setExitDate(exitdate);
        try {
            exitList = stfImlp.select(exit);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(exitList != null){
            request.setAttribute("exitList",exitList);
        }
        request.getRequestDispatcher("exitlist.jsp").forward(request,response);



    }
}
