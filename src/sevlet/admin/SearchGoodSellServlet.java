package sevlet.admin;

import or.homework.dao.impl.ExitImpl;
import or.homework.dao.impl.GoodsSellImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Exit;
import or.homework.vo.GoodsSell;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchGoodSellServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取信息
        Long goodsellid = Long.valueOf(request.getParameter("goodsellID"));
        //String staffname = request.getParameter("staffName");
        Long merchandisingid = Long.valueOf(request.getParameter("merchandisingID"));

        //ConnectJDBC db = new ConnectJDBC();
        GoodsSellImpl goodsSellImlp = new GoodsSellImpl();
        GoodsSell goodsSell = new GoodsSell();
        List<GoodsSell> goodsSellsList = null;

        goodsSell.setGsID(goodsellid);
        goodsSell.setMerchandisingid(merchandisingid);
        try {
            goodsSellsList = goodsSellImlp.select(goodsSell);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(goodsSellsList != null){
            request.setAttribute("goodsSellsList",goodsSellsList);
        }
        request.getRequestDispatcher("goodsSellsList.jsp").forward(request,response);



    }
}
