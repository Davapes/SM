package sevlet.admin;

import or.homework.dao.impl.MerchandisingImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Merchandising;
import or.homework.vo.Staff;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class SearchMerchandisingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Long MERCHANDISINGID = Long.valueOf(request.getParameter("Merchandising ID"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(request.getParameter("Merchandising Date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        MerchandisingImpl mcdsImpl=new MerchandisingImpl();
        Merchandising merchandising=new Merchandising();
        List<Merchandising>MerchandisingList=null;
        merchandising.setmID(MERCHANDISINGID);
        merchandising.setmDate(date);
        try{
            MerchandisingList=mcdsImpl.select(merchandising);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (MerchandisingList != null) {
            request.setAttribute("MerchandisingList", MerchandisingList);
            request.getRequestDispatcher("MerchandisingManager.jsp").forward(request, response);
        }

    }
}
