package sevlet.admin;

import or.homework.dao.impl.CommodityImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Staff;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class SearchCommodityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String CNAME = request.getParameter("Name");
        String BRAND = request.getParameter("Supplier");
        /*
        ServletContext ctx=this.getServletContext();
        String server=ctx.getInitParameter("server");
        String dbname=ctx.getInitParameter("dbname");
        String user=ctx.getInitParameter("user");
        String pwd=ctx.getInitParameter("pwd");
        */
        CommodityImpl comImlp = new CommodityImpl();
        Commodity commodity = new Commodity();
        List<Commodity> Commoditylist = null;
        commodity.setcName(CNAME);
        commodity.setBrand(BRAND);
        try {
            Commoditylist = comImlp.select(commodity);
        }
        /*
        //commodity.getConn(server,dbname,user,pwd);
            if(CNAME!=null&&CNAME.length()>0&&(BRAND==null||BRAND.equals(""))){
                Commoditylist.add(commodity.getcName(CNAME));
            }else if (BRAND!=null&&BRAND.length()>0&&(CNAME==null||CNAME.equals(""))){
                Commoditylist=commodity.getBrand(BRAND);
            }else if(CNAME!=null&&CNAME.length()>0&&BRAND!=null&&BRAND.length()>0){
                Commoditylist=commodity.(CNAME.Integer.parseInt(BRAND));
            }else{
                Commoditylist=commodity.getAllCommodity();
            }
        }*/ catch (Exception e) {
            e.printStackTrace();
        }
        if (Commoditylist != null) {
            request.setAttribute("CommodityList", Commoditylist);
            request.getRequestDispatcher("CommodityManager.jsp").forward(request, response);
        }

    }
}