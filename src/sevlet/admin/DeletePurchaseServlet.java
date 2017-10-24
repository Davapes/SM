package sevlet.admin;

import or.homework.dao.impl.PurchaseImopl;
import or.homework.vo.Purchase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet9")
public class DeletePurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        Long pchid = Long.valueOf(request.getParameter("pchID"));
        PurchaseImopl purchaseImopl = new PurchaseImopl();
        Purchase purchase = new Purchase();
        purchase.setPchID(pchid);
        try{

            //向表中删除一条记录
            purchaseImopl.delete(purchase);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
