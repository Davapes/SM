package sevlet.admin;

import or.homework.dao.impl.ProcurementImpl;
import or.homework.vo.Procurement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Servlet4")
public class AddProcurementServlet extends HttpServlet {
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
         private Long pid;
    private Long commodityid;
    private Long purchaseid;
    private Long pnum;//采购数量
    private Long pje;//采购金额
         */



        Long commodityid = Long.valueOf(request.getParameter("commodityID"));
        Long purchaseid = Long.valueOf(request.getParameter("purchaseID"));
        Long pnum = Long.valueOf(request.getParameter("pNum"));
        Long pje = Long.valueOf(request.getParameter("pJE"));
        ProcurementImpl commodityImpl = new ProcurementImpl();
        Procurement procurement = new Procurement();

        procurement.setCommodityid(commodityid);
        procurement.setPurchaseid(purchaseid);
        procurement.setPnum(pnum);
        procurement.setPje(pje);


        try{

            //向表中插入一条记录
            commodityImpl.add(procurement);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
