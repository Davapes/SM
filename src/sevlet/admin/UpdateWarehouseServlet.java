package sevlet.admin;

import or.homework.dao.impl.WarehouseImpl;
import or.homework.vo.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet16")
public class UpdateWarehouseServlet extends HttpServlet {
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
            private Long whID;
    private Long sID;
    private String whName;
    private String whAddress;
    private Long capacity;//仓库容量
    private Long leftCapacity;//仓库剩余容量
         */


        Long sID = Long.valueOf(request.getParameter("sid"));
        String whName = (request.getParameter("whname"));
        String whAddress = (request.getParameter("whaddress"));
        Long  capacity= Long.valueOf(request.getParameter("Capacity"));
        Long leftCapacity = Long.valueOf(request.getParameter("ssalary"));
        WarehouseImpl commodityImpl = new WarehouseImpl();
        Warehouse warehouse = new Warehouse();

        warehouse.setsID(sID);
        warehouse.setWhName(whName);
        warehouse.setWhAddress(whAddress);
        warehouse.setCapacity(capacity);
        warehouse.setLeftCapacity(leftCapacity);
        try{

            //向表中更新一条记录
            commodityImpl.update(warehouse);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
