package sevlet.admin;

import or.homework.dao.impl.GoodsSellImpl;
import or.homework.vo.GoodsSell;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet12")
public class UpdateGoodsSellServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private Long gsID;
        private Long commodityid;
        private Long merchandisingid;
        private Long gsNum;//商品数量
        private Long gsje;//商品金额
        private Long gsylje;//商品盈利
         */

        Long gsid = Long.valueOf(request.getParameter("gsID"));
        Long commodityid = Long.valueOf(request.getParameter("commodityID"));
        Long merchandisingid = Long.valueOf(request.getParameter("merchandisingID"));
        Long gsnum = Long.valueOf(request.getParameter("gsNum"));
        Long gsje = Long.valueOf(request.getParameter("gsJe"));
        Long gsylje = Long.valueOf(request.getParameter("gsYlje"));


        GoodsSellImpl goodsSellImpl = new GoodsSellImpl();
        GoodsSell goodsSell = new GoodsSell();

        goodsSell.setGsID(gsid);
        goodsSell.setCommodityid(commodityid);
        goodsSell.setMerchandisingid(merchandisingid);
        goodsSell.setGsNum(gsnum);
        goodsSell.setGsje(gsje);
        goodsSell.setGsylje(gsylje);

        try{

            //向表中更新一条记录
            goodsSellImpl.update(goodsSell);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
