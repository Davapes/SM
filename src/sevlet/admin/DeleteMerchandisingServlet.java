package sevlet.admin;

import or.homework.dao.impl.MerchandisingImpl;
import or.homework.vo.Merchandising;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet8")
public class DeleteMerchandisingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charset=UTF-8");
        Long mID = Long.valueOf(request.getParameter("mid"));
        MerchandisingImpl merchandisingimpl=new MerchandisingImpl();
        Merchandising merchandising=new Merchandising();
        merchandising.setmID(mID);

        try {

            //向表中删除一条记录
            merchandisingimpl.delete(merchandising);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
