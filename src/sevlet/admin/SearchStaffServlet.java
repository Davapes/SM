package sevlet.admin;

import or.homework.dao.impl.StaffImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Staff;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchStaffServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long staffid = Long.valueOf(request.getParameter("staffID"));
        String staffname = request.getParameter("staffName");

        //ConnectJDBC db = new ConnectJDBC();
        StaffImpl stfImlp = new StaffImpl();
        Staff staff = new Staff();
        List<Staff> staffList = null;

        staff.setsID(staffid);
        staff.setsName(staffname);
        try {
            staffList = stfImlp.select(staff);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(staffList != null){
            request.setAttribute("staffList",staffList);
        }
        request.getRequestDispatcher("staffList.jsp").forward(request,response);



    }
}
