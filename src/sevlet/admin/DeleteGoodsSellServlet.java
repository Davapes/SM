package sevlet.admin;

import or.homework.dao.impl.GoodsSellImpl;
import or.homework.vo.GoodsSell;

import java.io.PrintWriter;
import java.util.List;

public class DeleteGoodsSellServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charst=GBK");
        Long gsID = Long.valueOf(request.getParameter("gsid"));
        GoodsSellImpl goodsSellImlp = new GoodsSellImpl();
        GoodsSell goodsSell = new GoodsSell();
        goodsSell.setGsID(gsID);

        try {

            //向表中删除一条记录
            goodsSellImlp.delete(goodsSell);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
