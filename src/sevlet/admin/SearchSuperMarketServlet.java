package sevlet.admin;

import or.homework.dao.impl.SuperMarketImpl;
import or.homework.vo.SuperMarket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet")
public class SearchSuperMarketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取信息
        Long superMarketid = Long.valueOf(request.getParameter("superMarketID"));
        String superMarketname = request.getParameter("superMarketName");

        //ConnectJDBC db = new ConnectJDBC();
        SuperMarketImpl supmlp = new SuperMarketImpl();
        SuperMarket superMarket = new SuperMarket();
        List<SuperMarket> superMarketsList = null;

        superMarket.setSmID(superMarketid);
        superMarket.setSmName(superMarketname);
        try {
            superMarketsList = supmlp.select(superMarket);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(superMarketsList != null){
            request.setAttribute("superMarketList",superMarketsList);
        }
        request.getRequestDispatcher("supermarketList.jsp").forward(request,response);

    }
}
