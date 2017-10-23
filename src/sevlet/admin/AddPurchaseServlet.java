package sevlet.admin;
import or.homework.dao.impl.*;
import or.homework.util.ConnectJDBC;
import or.homework.vo.*;

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
public class AddPurchaseServlet extends HttpServlet{
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
        private Long pchID;
        private Long pchMoney;
        private Date pchDate;
        private Long staffid;
        private Long supplierid;
         */

        Long pchid = Long.valueOf(request.getParameter("pchID"));
        Long pchmoney = Long.valueOf(request.getParameter("pchMoney"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pchdate = null;
        try {
            pchdate = sdf.parse(request.getParameter("pchDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long staffid = Long.valueOf(request.getParameter("staffID"));
        Long supplierid = Long.valueOf(request.getParameter("supplierID"));

        PurchaseImopl purchaseImopl = new PurchaseImopl();
        Purchase purchase = new Purchase();



        try{

            //向表中插入一条记录
            purchaseImopl.add(purchase);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
