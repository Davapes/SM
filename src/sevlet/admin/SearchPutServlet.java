package sevlet.admin;

import or.homework.dao.impl.PutImpl;
import or.homework.dao.impl.StaffImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Put;
import or.homework.vo.Staff;

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

public class SearchPutServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long putid = Long.valueOf(request.getParameter("putID"));
        //String staffname = request.getParameter("staffName");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date putdate = null;
        try {
            putdate = sdf.parse(request.getParameter("putDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //ConnectJDBC db = new ConnectJDBC();
        PutImpl putImlp = new PutImpl();
        Put put = new Put();
        List<Put> putList = null;

        put.setPutID(putid);
        put.setPutrq(putdate);
        try {
            putList = putImlp.select(put);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(putList != null){
            request.setAttribute("putList",putList);
        }
        request.getRequestDispatcher("putList.jsp").forward(request,response);



    }
}
