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

public class AddSupermarketServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private Long smID;
        private String smName;
        private String manger;//经理
        private String smAdds;
         */

        Long smid = Long.valueOf(request.getParameter("smID"));
        String smname = request.getParameter("smName");
        String manager = request.getParameter("Manager");
        String smaddrs = request.getParameter("smAddrs");

        SuperMarketImpl supermarketImpl = new SuperMarketImpl();
        SuperMarket superMarket = new SuperMarket();

        superMarket.setSmID(smid);
        superMarket.setSmName(smname);
        superMarket.setManger(manager);
        superMarket.setSmAdds(smaddrs);
        try{

            //向表中插入一条记录
            supermarketImpl.add(superMarket);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
