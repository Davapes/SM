package sevlet.admin;

import or.homework.dao.impl.CommodityImpl;
import or.homework.dao.impl.LoginImpl;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Login;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UpdateCommodityServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doPost( request,response);
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        //将输入转换为中文
        request.setCharacterEncoding("GBK");
        //设置输出为中文
        response.setContentType("text/html;charset=GBK");
        //获取输出流
        PrintWriter out = response.getWriter();

        /*
        private String cName;//名字
        private String units;//单位
        private String origin;//产地
        private String brand;//商标
        private Long cprice;//价格
        private Long jinjia;//进价
        private Date cgrq;//采购日期
        private Long supplierid;//供应商id
        private String baozhiqi;//保质期
        private Long warehouseid;//仓库id
         */


        Long commodityid=Long.valueOf(request.getParameter("commodityID"));
        String commodityname = request.getParameter("commodityName");
        String origin = request.getParameter("Origin");
        String brand = request.getParameter("Brand");
        Long cprice = Long.valueOf(request.getParameter("cPrice"));
        Long jinjia = Long.valueOf(request.getParameter("Jinjia"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date caigouDate = null;
        try {
            caigouDate = sdf.parse(request.getParameter("caigouDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long supplierid = Long.valueOf(request.getParameter("supplierID"));
        String baozhiqi = request.getParameter("Baozhiqi");
        Long warehouseid = Long.valueOf(request.getParameter("warehouseID"));


        CommodityImpl commodityImpl = new CommodityImpl();
        Commodity commodity = new Commodity();

        commodity.setcID(commodityid);
        commodity.setcName(commodityname);
        commodity.setOrigin(origin);
        commodity.setBrand(brand);
        commodity.setCprice(cprice);
        commodity.setJinjia(jinjia);
        commodity.setCgrq(caigouDate);
        commodity.setSupplierid(supplierid);
        commodity.setBaozhiqi(baozhiqi);
        commodity.setWarehouseid(warehouseid);

        try{

            //向表中插入一条记录
            commodityImpl.update(commodity);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
