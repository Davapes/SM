package or.homework.dao.impl;

import or.homework.dao.ICommodityDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommodityImpl implements ICommodityDao {
    @Override
    public void add(Commodity commodity) {
        String sql = "INSERT INTO Commodity (cName,units,origin,brand,cprice,jinjia,cgrq,supplierid,baozhiqi,warehouseid) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,commodity.getcName());
            pst.setString(2,commodity.getUnits());
            pst.setString(3, commodity.getOrigin());
            pst.setString(4, commodity.getBrand());
            pst.setLong(5,commodity.getCprice());
            pst.setLong(6,commodity.getJinjia());
            pst.setDate(7, (Date) commodity.getCgrq());
            pst.setLong(8, commodity.getSupplierid());
            pst.setString(9,commodity.getBaozhiqi());
            pst.setLong(10,commodity.getWarehouseid());
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Commodity commodity) {
        String sql = "DELETE FROM Commodity WHERE cID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, commodity.getcID());
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Commodity commodity) {
        String sql = "UPDATE Commodity SET cName = ?,units = ?, origin = ?,brand = ?,cprice = ?,jinjia = ?,cgrq = ?,supplierid = ?,baozhiqi = ?,warehouseid = ? WHERE cID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,commodity.getcName());
            pst.setString(2,commodity.getUnits());
            pst.setString(3, commodity.getOrigin());
            pst.setString(4, commodity.getBrand());
            pst.setLong(5,commodity.getCprice());
            pst.setLong(6,commodity.getJinjia());
            pst.setDate(7, (Date) commodity.getCgrq());
            pst.setLong(8, commodity.getSupplierid());
            pst.setString(9,commodity.getBaozhiqi());
            pst.setLong(10,commodity.getWarehouseid());
            pst.setLong(11,commodity.getcID());
            pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public List<Commodity> select(Commodity commodity) {
        String sql="SELECT * FROM Commodity WHERE 1=1 ";
        List<Commodity>result=new ArrayList<Commodity>();
        if(commodity.getcID()!=null){
            sql+=" and cID = "+"'"+commodity.getcID()+"'";
        }
        if(commodity.getcName()!=null){
            sql+=" and cName = "+"'"+commodity.getcName()+"'";
        }
        if(commodity.getUnits()!=null){
            sql+=" and units = "+"'"+commodity.getUnits()+"'";
        }
        if(commodity.getOrigin()!=null){
            sql+=" and origin = "+"'"+commodity.getOrigin()+"'";
        }
        if(commodity.getBrand()!=null){
            sql+=" and brand = "+"'"+commodity.getBrand()+"'";
        }
        if(commodity.getCprice()!=null){
            sql+=" and cprice = "+"'"+commodity.getCprice()+"'";
        }
        if(commodity.getJinjia()!=null){
            sql+=" and jinjia = "+"'"+commodity.getJinjia()+"'";
        }
        if(commodity.getCgrq()!=null){
            sql+=" and cgrq = "+"'"+commodity.getCgrq()+"'";
        }
        if(commodity.getSupplierid()!=null){
            sql+=" and supplier = "+"'"+commodity.getSupplierid()+"'";
        }
        if(commodity.getBaozhiqi()!=null){
            sql+=" and baozhiqi = "+"'"+commodity.getBaozhiqi()+"'";
        }
        if(commodity.getWarehouseid()!=null){
            sql+=" and warehouseid = "+"'"+commodity.getWarehouseid()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Commodity b=new Commodity();
                b.setcID(rs.getLong("cID"));
                b.setcName(rs.getString("cName"));
                b.setUnits(rs.getString("units"));
                b.setOrigin(rs.getString("origin"));
                b.setBrand(rs.getString("brand"));
                b.setCprice(rs.getLong("cprice"));
                b.setJinjia(rs.getLong("jinjia"));
                b.setCgrq(rs.getDate("cgrq"));
                b.setSupplierid(rs.getLong("supplierid"));
                b.setBaozhiqi(rs.getString("baozhiqi"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                result.add(b);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

}


