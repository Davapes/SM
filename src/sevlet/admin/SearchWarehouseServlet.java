package sevlet.admin;

import or.homework.dao.impl.WarehouseImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Warehouse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class SearchWarehouseServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long whid = Long.valueOf(request.getParameter("staffID"));
        String whname = request.getParameter("staffName");
        String whaddress = request.getParameter("whAddress");
        //ConnectJDBC db = new ConnectJDBC();
        WarehouseImpl whImlp = new WarehouseImpl();
        Warehouse wh = new Warehouse();
        List<Warehouse> whList = null;

        wh.setWhID(whid);
        wh.setWhName(whname);
        try {
            whList = whImlp.select(wh);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(whList != null){
            request.setAttribute("whList",whList);
        }
        request.getRequestDispatcher("warehouseList.jsp").forward(request,response);



    }
}
