package sevlet.admin;

import or.homework.dao.impl.PutImpl;
import or.homework.dao.impl.StaffImpl;
import or.homework.vo.Put;
import or.homework.vo.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Servlet6")
public class AddStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charst=UTF-8");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
           private Long sID;
    private Long tID;//领导id
    private String sName;
    private String sSex;
    private Long sPhone;
    private Long sSalary;
    private Date sDate;
    private String sAdds;
    private String sProfessional;
         */


        Long tID = Long.valueOf(request.getParameter("tid"));
        String sName = (request.getParameter("sname"));
        String sSex = (request.getParameter("ssex"));
        Long sPhone = Long.valueOf(request.getParameter("sphonr"));
        Long sSalary = Long.valueOf(request.getParameter("ssalary"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sDate = null;
        try {
            sDate = sdf.parse(request.getParameter("sdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sAdds = (request.getParameter("sadds"));
        String sProfessional = (request.getParameter("sprofessional"));
        StaffImpl commodityImpl = new StaffImpl();
        Staff staff = new Staff();

        staff.settID(tID);
        staff.setsName(sName);
        staff.setsSex(sSex);
        staff.setsPhone(sPhone);
        staff.setsSalary(sSalary);
        staff.setsDate(sDate);
        staff.setsAdds(sAdds);
        staff.setsProfessional(sProfessional);

        try{

            //向表中插入一条记录
            commodityImpl.add(staff);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
