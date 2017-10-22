import sun.net.httpserver.HttpsServerImpl;

import java.io.IOException;
import java.util.List;

public class SearchGoodAdminServlet extends HttpServlet{
    protected void  doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }
    protected  void doPost(HttpServletRequest request,HttpServletResponse response)throws  ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String goodname=request.getParameter("goodname");
        String  pid=request.getParameter("publisher");
        ServletContext ctx=this.getServletContext();
        String server=ctx.getInitParameter("server");
        String dbname=ctx.getInitParameter("dbname");
        String user=ctx.getInitParameter("user");
        String pwd=ctx.getInitParameter("pwd");
        GoodDao dao=new GoodDao();
        List<Good> Goodlist=null;
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