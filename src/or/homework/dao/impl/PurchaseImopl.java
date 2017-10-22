package or.homework.dao.impl;

import or.homework.dao.IPurchaseDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Purchase;
import or.homework.vo.Staff;
import or.homework.vo.Supplier;

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
        List<Purchase>result=new ArrayList<Purchase>();
        if(purchase.getPchID()!=null){
            sql+=" and pchID = "+"'"+purchase.getPchID()+"'";
        }
        if(purchase.getPchMoney()!=null){
            sql+=" and pchMoney = "+"'"+purchase.getPchMoney()+"'";
        }
        if(purchase.getPchDate()!=null){
            sql+=" and pchDate = "+"'"+purchase.getPchDate()+"'";
        }
        if(purchase.getStaffid()!=null){
            sql+=" and staffid = "+"'"+purchase.getStaffid()+"'";
        }
        if(purchase.getSupplierid()!=null){
            sql+=" and supplierid = "+"'"+purchase.getSupplierid()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
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
        return result;
    }

    @Override
    public List<Purchase> query(Purchase purchase) {
        String sql = "SELECT * FROM Purchase AS P,Staff AS S WHERE P.pchID = S.sID";
        List<Object> params = new ArrayList<Object>();
        List<Purchase> result = new ArrayList<Purchase>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Purchase b = new Purchase();
                b.setPchID(rs.getLong("pchID"));
                b.setPchMoney(rs.getLong("pchMoney"));
                b.setPchDate(rs.getDate("pchDate"));
                b.setStaffid(rs.getLong("staffid"));
                b.setSupplierid(rs.getLong("supplierid"));
                Staff a = new Staff();
                a.setsID(rs.getLong("sID"));
                a.settID(rs.getLong("tID"));
                a.setsName(rs.getString("sName"));
                a.setsSex(rs.getNString("sSex"));
                a.setsPhone(rs.getLong("sPhone"));
                a.setsSalary(rs.getLong("sSalary"));
                a.setsDate(rs.getDate("sDate"));
                a.setsAdds(rs.getString("sAdds"));
                a.setsProfessional(rs.getString("sProfessional"));
                b.setNumber(a);
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

    @Override
    public List<Purchase> queryone(Purchase purchase) {
        String sql = "SELECT * FROM Purchase AS P,Supplier AS S WHERE P.pchID = S.supID";
        List<Object> params = new ArrayList<Object>();
        List<Purchase> result = new ArrayList<Purchase>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Purchase b = new Purchase();
                b.setPchID(rs.getLong("pchID"));
                b.setPchMoney(rs.getLong("pchMoney"));
                b.setPchDate(rs.getDate("pchDate"));
                b.setStaffid(rs.getLong("staffid"));
                b.setSupplierid(rs.getLong("supplierid"));
                Supplier a = new Supplier();
                a.setSupID(rs.getLong("supID"));
                a.setSupName(rs.getString("supName"));
                a.setSupAdds(rs.getString("supAdds"));
                a.setSupPhone(rs.getLong("supPhone"));
                a.setSupAccount(rs.getLong("supAccount"));
                a.setSupBank(rs.getString("supBank"));
                b.setNumeration(a);
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
