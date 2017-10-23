package sevlet.admin;

import or.homework.dao.impl.PurchaseImopl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Purchase;

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

public class SearchPurchaseServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        //获取信息

        Long pchid = Long.valueOf(request.getParameter("pchID"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date purchasedate = null;
        try {
            purchasedate = sdf.parse(request.getParameter("purchaseDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //ConnectJDBC db = new ConnectJDBC();
        //StaffImpl stfImlp = new StaffImpl();
        PurchaseImopl purchaseImopl = new PurchaseImopl();
        //Staff staff = new Staff();
        Purchase purchase = new Purchase();
        //List<Staff> staffList = null;
        List<Purchase> purchaseList = null;
        purchase.setPchID(pchid);
        purchase.setPchDate(purchasedate);
        try {
            purchaseList = purchaseImopl.select(purchase);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(purchaseList != null){
            request.setAttribute("purchaseList",purchaseList);
        }
        request.getRequestDispatcher("purchaseList.jsp").forward(request,response);



    }
}
