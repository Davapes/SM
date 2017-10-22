package sevlet.admin;

import or.homework.dao.impl.SupplierImpl;
import or.homework.vo.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet3")
public class SeachSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息
        Long supID = Long.valueOf(request.getParameter("supID"));
        String supName = request.getParameter("supName");

        //ConnectJDBC db = new ConnectJDBC();
        SupplierImpl supmlp = new SupplierImpl();
        Supplier supplier = new Supplier();
        List<Supplier> suppliersList = null;

        supplier.setSupID(supID );
        supplier.setSupName(supName);
        try {
            suppliersList = supmlp.select(supplier);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(suppliersList != null){
            request.setAttribute(" suppliersList",suppliersList);
        }
        request.getRequestDispatcher(" suppliersList.jsp").forward(request,response);

    }
}
