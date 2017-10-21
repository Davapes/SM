package sevlet.admin;

import or.homework.util.ConnectJDBC;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charst=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();
        //获取表单登录名
        String username = request.getParameter("userName");
        //获取表单用户密码
        String userpass = request.getParameter("userPass");
        //获取权限
        String role = request.getParameter("role");
        //获取当前注册时间
        /*
        Date curTime = new Date();
        //格式化当前日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String regtime = dateFormat.format(curTime);
        ServletContext ctx = this.getServletContext();
        //通过servletcontext 获得web.xml中设置的初始化参数
        /*
        String server = ctx.getInitParameter("server"); //获取服务器地址
        String dbname = ctx.getInitParameter("dbname"); //获取数据库名
        String dbuser = ctx.getInitParameter("user");     //获取数据库用户名
        String pwd = ctx.getInitParameter("pwd");       //获取数据库密码
        */
        ConnectJDBC db = new ConnectJDBC();
        User usr = new User();
        try{
            //连接数据库
            db.getConn();
            //向user表中插入一条记录
            usr.add(username,userpass,role);
            int rs = db.
        }

    }
}
