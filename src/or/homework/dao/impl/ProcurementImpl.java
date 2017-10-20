package or.homework.dao.impl;

import or.homework.dao.IProcurementDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Procurement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcurementImpl implements IProcurementDao{
    @Override
    public void add(Procurement procurement) {
        String sql = "INSERT INTO Procurement (pnum,commodityid,purchaseid) VALUES (?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,procurement.getPnum());
            pst.setLong(2, procurement.getCommodityid());
            pst.setLong(3, procurement.getPurchaseid());
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
        String sql = "UPDATE Procurement SET pnum = ?,commodityid = ?, purchaseid = ? WHERE pid = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, procurement.getPnum());
            pst.setLong(2, procurement.getCommodityid());
            pst.setLong(3,procurement.getPurchaseid());
            pst.setLong(4, procurement.getPid());
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
        List<Object>params=new ArrayList<Object>();
        List<Procurement>result=new ArrayList<Procurement>();
        if(procurement.getPid()!=null){
            sql+=" and pid ";
            params.add(procurement.getPid());
        }
        if(procurement.getPnum()!=null){
            sql+=" and pnum ";
            params.add(procurement.getPcnum());
        }
        if(procurement.getCommodityid()!=null){
            sql+=" and commodityid ";
            params.add(procurement.getCommodityid());
        }
        if(procurement.getPurchaseid()!=null){
            sql+=" and purchaseid ";
            params.add(procurement.getPurchaseid());
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for(int i=0;i<params.size();i++){
                if(params.get(i) instanceof Long){
                    pst.setLong(i+1, (Long)params.get(i));
                }
            }
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Procurement b=new Procurement();
                b.setPid(rs.getLong("pid"));
                b.setPnum(rs.getLong("pnum"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setPurchaseid(rs.getLong("purchaseid"));
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

