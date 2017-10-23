package sevlet.admin;

import or.homework.dao.impl.ProcurementImpl;
import or.homework.vo.Procurement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet2")
public class SeachProcurementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
            Long procurementid = Long.valueOf(request.getParameter("procurementid"));
        Long commodityid = Long.valueOf(request.getParameter("commodityid"));
        Long purchaseid = Long.valueOf(request.getParameter("purchaseid"));

        //ConnectJDBC db = new ConnectJDBC();
        ProcurementImpl pmImlp = new ProcurementImpl();
        Procurement procurement = new Procurement();
        List<Procurement> procurementList = null;

        procurement.setPid(procurementid);
        procurement.setCommodityid(commodityid);
        procurement.setPurchaseid(purchaseid);
        try {
            procurementList = pmImlp.select(procurement);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(procurementList != null){
            request.setAttribute("procurementList",procurementList);
        }
        request.getRequestDispatcher("procurementList.jsp").forward(request,response);

    }
}
