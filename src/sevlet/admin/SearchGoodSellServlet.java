package sevlet.admin;

import or.homework.dao.impl.ExitImpl;
import or.homework.dao.impl.GoodsSellImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Exit;
import or.homework.vo.GoodsSell;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchGoodSellServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long goodsellid = Long.valueOf(request.getParameter("goodsellID"));
        String staffname = request.getParameter("staffName");

        //ConnectJDBC db = new ConnectJDBC();
        GoodsSellImpl goodsSellImlp = new GoodsSellImpl();
        GoodsSell goodsSell = new
        List<Exit> exitList = null;

        exit.(staffid);
        staff.setsName(staffname);
        try {
            staffList = stfImlp.select(staff);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(staffList != null){
            request.setAttribute("staffList",staffList);
        }
        request.getRequestDispatcher("stafflist.jsp").forward(request,response);



    }
}
