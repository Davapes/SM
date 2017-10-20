package or.homework.dao.impl;

import or.homework.dao.IExitDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Exit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExitImpl implements IExitDao {
    @Override
    public void add(Exit exit) {
        String sql = "INSERT INTO Exit (staffid,exitDate,exitNum,supermarket,commodityid,warehouseid) VALUES (?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,exit.getStaffid());
            pst.setDate(2,(Date)exit.getExitDate());
            pst.setLong(3, exit.getExitNum());
            pst.setLong(4, exit.getSupermarket());
            pst.setLong(5,exit.getCommodityid());
            pst.setLong(5,exit.getWarehouseid());
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
    public void delete(Exit exit) {
        String sql = "DELETE FROM Exit WHERE exitID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, exit.getExitID());
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
    public void update(Exit exit) {
        String sql = "UPDATE Exit SET staffid = ?,exitDate = ?, exitNum = ?,supermarket = ?,commodityid = ?,warehouseid = ? WHERE exitID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,exit.getStaffid());
            pst.setDate(2, (Date) exit.getExitDate());
            pst.setLong(3,exit.getExitNum());
            pst.setLong(4,exit.getSupermarket());
            pst.setLong(5,exit.getCommodityid());
            pst.setLong(6, exit.getWarehouseid());
            pst.setLong(7,exit.getExitID());
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
    public List<Exit> select(Exit exit) {
        String sql="SELECT * FROM Exit WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Exit>result=new ArrayList<Exit>();
        if(exit.getExitID()!=null){
            sql+=" and exitID ";
            params.add(exit.getExitID());
        }
        if(exit.getExitID()!=null){
            sql+=" and staffid ";
            params.add(exit.getExitID());
        }
        if(exit.getExitDate()!=null){
            sql+=" and exitDate ";
            params.add(exit.getExitDate());
        }
        if(exit.getExitNum()!=null){
            sql+=" and exitNum ";
            params.add(exit.getExitNum());
        }
        if(exit.getSupermarket()!=null){
            sql+=" and supermarket ";
            params.add(exit.getSupermarket());
        }
        if(exit.getCommodityid()!=null){
            sql+=" and commodityid ";
            params.add(exit.getCommodityid());
        }
        if(exit.getWarehouseid()!=null){
            sql+=" and warehouseid ";
            params.add(exit.getWarehouseid());
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for(int i=0;i<params.size();i++){
                if(params.get(i) instanceof Long){
                    pst.setLong(i+1, (Long)params.get(i));
                }else if(params.get(i) instanceof Date){
                    pst.setDate(i+1, (Date) params.get(i));
                }
            }
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Exit b=new Exit();
                b.setExitID(rs.getLong("exitID"));
                b.setStaffid(rs.getLong("staffid"));
                b.setExitDate(rs.getDate("exitDate"));
                b.setExitNum(rs.getLong("exitNum"));
                b.setSupermarket(rs.getLong("supermarket"));
                b.setCommodityid(rs.getLong("commodityid"));
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
        return null;
    }
}
