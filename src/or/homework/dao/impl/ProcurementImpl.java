package or.homework.dao.impl;

import or.homework.dao.IProcurementDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Procurement;
import or.homework.vo.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcurementImpl implements IProcurementDao {
    @Override
    public void add(Procurement procurement) {
        String sql = "INSERT INTO Procurement (commodityid,purchaseid,pnum,pje) VALUES (?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, procurement.getCommodityid());
            pst.setLong(2, procurement.getPurchaseid());
            pst.setLong(3,procurement.getPnum());
            pst.setLong(4, procurement.getPje());
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
    public void delete(Procurement procurement) {
        String sql = "DELETE FROM Procurement WHERE pid = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, procurement.getPid());
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
    public void update(Procurement procurement) {
        String sql = "UPDATE Procurement SET commodityid = ?, purchaseid = ?,pnum = ?,pje = ? WHERE pid = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, procurement.getCommodityid());
            pst.setLong(2,procurement.getPurchaseid());
            pst.setLong(3, procurement.getPnum());
            pst.setLong(4, procurement.getPje());
            pst.setLong(5, procurement.getPid());
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
    public List<Procurement> select(Procurement procurement) {
        String sql="SELECT * FROM Procurement WHERE 1=1 ";
        List<Procurement>result=new ArrayList<Procurement>();
        if(procurement.getPid()!=null){
            sql+=" and pid = "+"'"+procurement.getPid()+"'";
        }
        if(procurement.getCommodityid()!=null){
            sql+=" and commodityid = "+"'"+procurement.getCommodityid()+"'";
        }
        if(procurement.getPurchaseid()!=null){
            sql+=" and purchaseid = "+"'"+procurement.getPurchaseid()+"'";
        }
        if(procurement.getPnum()!=null){
            sql+=" and pnum = "+"'"+procurement.getPnum()+"'";
        }
        if(procurement.getPje()!=null){
            sql+=" and pje = "+"'"+procurement.getPje()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Procurement b=new Procurement();
                b.setPid(rs.getLong("pid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setPurchaseid(rs.getLong("purchaseid"));
                b.setPnum(rs.getLong("pnum"));
                b.setPje(rs.getLong("pje"));
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
    public List<Procurement> query(Procurement procurement) {
        String sql = "SELECT * FROM Procurement AS P,Commodity AS C WHERE P.pid = C.cID";
        List<Object> params = new ArrayList<Object>();
        List<Procurement> result = new ArrayList<Procurement>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Procurement b = new Procurement();
                b.setPid(rs.getLong("pid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setPurchaseid(rs.getLong("purchaseid"));
                b.setPnum(rs.getLong("pnum"));
                b.setPje(rs.getLong("pje"));
                Commodity a = new Commodity();
                a.setcID(rs.getLong("cID"));
                a.setcName(rs.getString("cName"));
                a.setUnits(rs.getString("units"));
                a.setOrigin(rs.getString("origin"));
                a.setBrand(rs.getString("brand"));
                a.setCprice(rs.getLong("cprice"));
                a.setJinjia(rs.getLong("jinjia"));
                a.setCgrq(rs.getDate("cgrq"));
                a.setSupplierid(rs.getLong("supplierid"));
                a.setBaozhiqi(rs.getString("baozhiqi"));
                a.setWarehouseid(rs.getLong("warehouseid"));
                b.setNum(a);
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
    public List<Procurement> queryone(Procurement procurement) {
        String sql = "SELECT * FROM Procurement AS P,Purchase AS C WHERE P.pid = C.pchID";
        List<Object> params = new ArrayList<Object>();
        List<Procurement> result = new ArrayList<Procurement>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Procurement b = new Procurement();
                b.setPid(rs.getLong("pid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setPurchaseid(rs.getLong("purchaseid"));
                b.setPnum(rs.getLong("pnum"));
                b.setPje(rs.getLong("pje"));
                Purchase a = new Purchase();
                a.setPchID(rs.getLong("pchID"));
                a.setPchMoney(rs.getLong("pchMoney"));
                a.setPchDate(rs.getDate("pchDate"));
                a.setStaffid(rs.getLong("staffid"));
                a.setSupplierid(rs.getLong("supplierid"));
                b.setPcnum(a);
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

