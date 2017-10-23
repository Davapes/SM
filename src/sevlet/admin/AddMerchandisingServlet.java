package sevlet.admin;

import or.homework.dao.impl.CommodityImpl;
import or.homework.dao.impl.LoginImpl;
import or.homework.dao.impl.MerchandisingImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Login;
import or.homework.vo.Merchandising;
import or.homework.vo.Staff;

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

public class AddMerchandisingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();

//        private Long mID;
//        private Long mAmount;//销售金额
//        private Long Profit;//盈利金额
//        private Long staffid;//销售员id
//        private Date mDate;
//        private Staff staff;//销售员对象

        Long MerchandisingID = Long.valueOf(request.getParameter("Merchandising ID"));
        Long MerchandisingAmount = Long.valueOf(request.getParameter("Merchandising Amount"));
        Long Profit = Long.valueOf(request.getParameter("Merchandising Profit"));
        Long StaffID = Long.valueOf(request.getParameter("Staff ID"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date MerchandisingDate = null;
        try {
            MerchandisingDate = sdf.parse(request.getParameter("MerchandisingDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MerchandisingImpl merchandisingimpl=new MerchandisingImpl();
        Merchandising merchandising=new Merchandising();

        merchandising.setmID(MerchandisingID);
        merchandising.setmAmount(MerchandisingAmount);
        merchandising.setProfit(Profit);
        merchandising.setStaffid(StaffID);
        merchandising.setmDate(MerchandisingDate);

        try{

            //向表中插入一条记录
            merchandisingimpl.add(merchandising);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
