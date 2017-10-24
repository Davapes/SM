package sevlet.admin;

import or.homework.dao.impl.WarehouseImpl;
import or.homework.vo.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet11")
public class DeleteWarehouseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        Long whID = Long.valueOf(request.getParameter("whID"));
        WarehouseImpl commodityImpl = new WarehouseImpl();
        Warehouse warehouse = new Warehouse();
        warehouse.setWhID(whID);
        try{

            //向表中删除一条记录
            commodityImpl.delete(warehouse);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
