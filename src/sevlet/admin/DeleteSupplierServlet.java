package sevlet.admin;

import or.homework.dao.impl.SupplierImpl;
import or.homework.vo.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet10")
public class DeleteSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();
        Long supid = Long.valueOf(request.getParameter("supID"));
        SupplierImpl supplierImpl = new SupplierImpl();
        Supplier supplier = new Supplier();
        supplier.setSupID(supid);
        try{

            //向表中删除一条记录
            supplierImpl.delete(supplier);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
