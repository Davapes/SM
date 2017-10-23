package sevlet.admin;
import com.sun.tools.javah.Util;
import or.homework.dao.impl.*;
import or.homework.util.ConnectJDBC;
import or.homework.vo.*;

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
public class DeleteStaffServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();


        Long staffid = Long.valueOf(request.getParameter("staffID"));


        StaffImpl putImpl = new StaffImpl();
        Staff staff = new Staff();

        staff.setsID(staffid);

        try {

            //向表中插入一条记录
            StaffImpl.delete(staff);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
