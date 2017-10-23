package sevlet.admin;

import or.homework.dao.impl.*;
import or.homework.util.ConnectJDBC;
import or.homework.vo.*;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

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

public class UpdateSupplierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private Long supID;
    private String supName;
    private String supAdds;
    private Long supPhone;
    private Long supAccount;
    private String supBank;
         */

        Long supid = Long.valueOf(request.getParameter("supID"));
        String supname = request.getParameter("supName");
        String supaddrs = request.getParameter("supAddrs");
        Long supphone = Long.valueOf(request.getParameter("supPhone"));
        Long supaccount = Long.valueOf(request.getParameter("supAccount"));
        String supbank = request.getParameter("supBank");

        SupplierImpl supplierImpl = new SupplierImpl();
        Supplier supplier = new Supplier();

        supplier.setSupID(supid);
        supplier.setSupName(supname);
        supplier.setSupAdds(supaddrs);
        supplier.setSupPhone(supphone);
        supplier.setSupAccount(supaccount);
        supplier.setSupBank(supbank);

        try{

            //向表中插入一条记录
            supplierImpl.update(supplier);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
