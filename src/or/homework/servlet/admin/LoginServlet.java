package or.homework.servlet.admin;

import or.homework.dao.impl.LoginImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Login;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class LoginServlet extends HttpServlet{
    public void destory(){
        super.destroy();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String userpass = request.getParameter("password");
//        ServletContext ctx=this.getServletContext();
//        String server=ctx.getInitParameter("server");
//        String dbname=ctx.getInitParameter("dbname");
//        String user=ctx.getInitParameter("user");
//        String pwd=ctx.getInitParameter("pwd");
        ConnectJDBC db=new ConnectJDBC();
        try {
           db.getConn();
            Login login=new Login();
            LoginImpl loginImpl=new LoginImpl();
            login.setUsername(username);
            login.setPassword(userpass);
            List<Login> lists=loginImpl.select(login);
            if (lists.size()!=0) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String logtime = dateFormat.format(new Date());
                session.setAttribute("logtime", logtime);
                //向客户端发送Cookie
                Cookie cookie = new Cookie("userName", username);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(cookie);
                RequestDispatcher dispatcher = request.getRequestDispatcher("top.jsp");
                dispatcher.forward(request, response);
            } else {
                out.print("登陆失败！");
                out.println("<br><a href='index.jsp'>重新登录</a>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init()throws ServletException {
    }

}
