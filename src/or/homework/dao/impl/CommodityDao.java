package or.homework.dao.impl;

import or.homework.dao.ICommodityDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDao implements ICommodityDao {
    @Override
    public void add(Commodity commodity) {
        String sql = "INSERT INTO Commodity (cName,units,origin,brand) VALUES (?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,commodity.getcName());
            pst.setString(2,commodity.getUnits());
            pst.setString(3, commodity.getOrigin());
            pst.setString(4, commodity.getBrand());
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
        String sql = "UPDATE Commodity SET cName = ?,units = ?, origin = ?,brand = ? WHERE cID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, commodity.getcID());
            pst.setString(2, commodity.getcName());
            pst.setString(3,commodity.getUnits());
            pst.setString(4, commodity.getOrigin());
            pst.setString(5,commodity.getBrand());
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
        List<Object>params=new ArrayList<Object>();
        List<Commodity>result=new ArrayList<Commodity>();
        if(commodity.getcID()!=null){
            sql+=" and cID ";
            params.add(commodity.getcID());
        }
        if(commodity.getcName()!=null){
            sql+=" and cName ";
            params.add(commodity.getcName());
        }
        if(commodity.getUnits()!=null){
            sql+=" and units ";
            params.add(commodity.getUnits());
        }
        if(commodity.getOrigin()!=null){
            sql+=" and origin ";
            params.add(commodity.getOrigin());
        }
        if(commodity.getBrand()!=null){
            sql+=" and brand ";
            params.add(commodity.getBrand());
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for(int i=0;i<params.size();i++){
                if(params.get(i) instanceof Long){
                    pst.setLong(i+1, (Long)params.get(i));
                }else if(params.get(i) instanceof String){
                    pst.setString(i+1, (String)params.get(i));
                }
            }
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Commodity b=new Commodity();
                b.setcID(rs.getLong("cID"));
                b.setcName(rs.getString("cName"));
                b.setUnits(rs.getString("units"));
                b.setOrigin(rs.getString("origin"));
                b.setBrand(rs.getString("brand"));
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
        return null;
    }
    }
}
