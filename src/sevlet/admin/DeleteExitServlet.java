package sevlet.admin;
import com.sun.tools.javah.Util;
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

public class DeleteExitServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        //将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        //获取输出流
        PrintWriter out = response.getWriter();


        Long exitid = Long.valueOf(request.getParameter("exitID"));


        ExitImpl exitImpl = new ExitImpl();
        Exit exit = new Exit();

        exit.setExitID(exitid);

        try {

            //向表中插入一条记录
            exitImpl.delete(exit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
