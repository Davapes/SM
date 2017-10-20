package or.homework.dao.impl;

import or.homework.dao.IPurchaseDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseImopl implements IPurchaseDao {
    @Override
    public void add(Purchase purchase) {
        String sql = "INSERT INTO Purchase (pchMoney,pchDate,staffid,supplierid) VALUES (?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,purchase.getPchMoney());
            pst.setDate(2, (Date) purchase.getPchDate());
            pst.setLong(3, purchase.getStaffid());
            pst.setLong(4,purchase.getSupplierid());
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
    public void delete(Purchase purchase) {
        String sql = "DELETE FROM Purchase WHERE pchID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, purchase.getPchID());
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
    public void update(Purchase purchase) {
        String sql = "UPDATE Purchase SET pchMoney = ?,pchDate = ?, staffid = ?,supplierid = ? WHERE pchID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, purchase.getPchMoney());
            pst.setDate(2, (Date) purchase.getPchDate());
            pst.setLong(3,purchase.getStaffid());
            pst.setLong(4, purchase.getSupplierid());
            pst.setLong(5,purchase.getPchID());
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
    public List<Purchase> select(Purchase purchase) {
        String sql="SELECT * FROM Purchase WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Purchase>result=new ArrayList<Purchase>();
        if(purchase.getPchID()!=null){
            sql+=" and pchID ";
            params.add(purchase.getPchID());
        }
        if(purchase.getPchMoney()!=null){
            sql+=" and pchMoney ";
            params.add(purchase.getPchMoney());
        }
        if(purchase.getPchDate()!=null){
            sql+=" and pchDate ";
            params.add(purchase.getPchDate());
        }
        if(purchase.getStaffid()!=null){
            sql+=" and staffid ";
            params.add(purchase.getStaffid());
        }
        if(purchase.getSupplierid()!=null){
            sql+=" and supplierid ";
            params.add(purchase.getSupplierid());
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
                Purchase b=new Purchase();
                b.setPchID(rs.getLong("pchID"));
                b.setPchMoney(rs.getLong("pchMoney"));
                b.setPchDate(rs.getDate("pchDate"));
                b.setStaffid(rs.getLong("staffid"));
                b.setSupplierid(rs.getLong("supplierid"));
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