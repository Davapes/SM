package sevlet.admin;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchBookServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");
        ServletContext ctx = this.getServletContext();
        //通过 ServletContext 获得web.xml中设置的初始化参数
        String server = ctx.getInitParameter("server");
        String dbname=ctx.getInitParameter("dbname");
        String pid=request.getParameter("publisher");
        ServletContext ctx=this.getServletContext();
        String server=ctx.getInitParameter("server");
        String dbname=ctx.getInitParameter("dbname");
        String user=ctx.getInitParameter("user");
        String pwd=ctx.getInitParameter("pwd");
        GoodDao dao=new GoodDao();
        List<Good>Goodlist=null;
        try{
            dao.getConn(server,dbname,user,pwd);
            if(Goodname!=null&&Goodname.length()>0&&(pid==null||pid.equals(""))){
                Goodlist=dao.getGoodByName(Goodname);
            }else if (pid!=null&&pid.length()>0&&(Goodname==null||Goodname.equals(""))){
Goodlist=dao.getGoodByPublisher(Integer.parseInt(pid));
}else if(Goodname!=null&&Goodname.length()>0&&pid!=null&&pid.length()>0){
Goodlist=dao.getGoodByNameAndPublish(Goodname.Integer.parseInt(pid));
}else{
Goodlist=dao.getAllGood();
}
}catch (Exception e){
e.printStackTrace();     }
if (Goodlist!=null){
request.setAttribute("GoodList",Goodlist);
request.getRequestDispatcher("GoodManager.jsp").forward(request,response);
}

}