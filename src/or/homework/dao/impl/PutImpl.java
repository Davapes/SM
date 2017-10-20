package or.homework.dao.impl;

import or.homework.dao.IPutDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Put;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PutImpl implements IPutDao {
    @Override
    public void add(Put put) {
        String sql = "INSERT INTO Put (cangkuguanliid,caigouid,commodityid,warehouseid) VALUES (?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,put.getCangkuguanliid());
            pst.setLong(2,put.getCaigouid());
            pst.setLong(3,put.getCommodityid());
            pst.setLong(4,put.getWarehouseid());
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
    public void delete(Put put) {
        String sql = "DELETE FROM Put WHERE putID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, put.getPutID());
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
    public void update(Put put) {
        String sql = "UPDATE Put SET cangkuguanliid = ?,caigouid = ?, commodityid = ?,warehouseid = ? WHERE putID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,put.getCangkuguanliid());
            pst.setLong(2,put.getCaigouid());
            pst.setLong(3,put.getCommodityid());
            pst.setLong(4,put.getWarehouseid());
            pst.setLong(5,put.getPutID());
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
    public List<Put> select(Put put) {
        String sql="SELECT * FROM Put WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Put>result=new ArrayList<Put>();
        if(put.getPutID()!=null){
            sql+=" and putID ";
            params.add(put.getPutID());
        }
        if(put.getCangkuguanliid()!=null){
            sql+=" and cangkuguanliid ";
            params.add(put.getCangkuguanliid());
        }
        if(put.getCaigouid()!=null){
            sql+=" and caigouid ";
            params.add(put.getCaigouid());
        }
        if(put.getCommodityid()!=null){
            sql+=" and commodityid ";
            params.add(put.getCommodityid());
        }
        if(put.getWarehouseid()!=null){
            sql+=" and warehouseid ";
            params.add(put.getWarehouseid());
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
                Put b=new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setCaigouid(rs.getLong("caigouid"));
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

