package sevlet.admin;

import or.homework.dao.impl.PutImpl;
import or.homework.vo.Put;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Servlet5")
public class AddPutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//将输入转换为中文
        request.setCharacterEncoding("UTF-8");
        //设置输出为中文
        response.setContentType("text/html;charst=UTF-8");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
          private Long putID;
    private Long cangkuguanliid;
    private Long supermarkid;
    private Long commodityid;
    private Long caigouid;
    private Long warehouseid;
    private Date putrq;//入库日期
    private Long putnum;//入库数量
         */


        Long cangkuguanliid = Long.valueOf(request.getParameter("cangkuguanliID"));
        Long supermarkid = Long.valueOf(request.getParameter("supermarketID"));
        Long commodityid = Long.valueOf(request.getParameter("commodityID"));
        Long caigouID = Long.valueOf(request.getParameter("caigouID"));
        Long warehouseID = Long.valueOf(request.getParameter("warehouseID"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date putrq = null;
        try {
            putrq = sdf.parse(request.getParameter("putRQ"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long putnum = Long.valueOf(request.getParameter("putNum"));
        PutImpl commodityImpl = new PutImpl();
        Put put = new Put();

        put.setCangkuguanliid(cangkuguanliid);
        put.setSupermarkid(supermarkid);
        put.setCommodityid(commodityid);
        put.setCaigouid(caigouID);
        put.setWarehouseid(warehouseID);
        put.setPutrq(putrq);
        put.setPutnum(putnum);

        try{

            //向表中插入一条记录
            commodityImpl.add(put);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
