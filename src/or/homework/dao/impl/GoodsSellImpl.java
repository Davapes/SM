package or.homework.dao.impl;

import or.homework.dao.IGoodsSellDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.GoodsSell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsSellImpl implements IGoodsSellDao {
    @Override
    public void add(GoodsSell goodsSell) {
        String sql = "INSERT INTO GoodsSell (gsNum,commodityid,merchandisingid) VALUES (?,?.?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,goodsSell.getGsNum());
            pst.setLong(2, goodsSell.getCommodityid());
            pst.setLong(3, goodsSell.getMerchandisingid());
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
    public void delete(GoodsSell goodsSell) {
        String sql = "DELETE FROM GoodsSell WHERE gsID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, goodsSell.getGsID());
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
    public void update(GoodsSell goodsSell) {
        String sql = "UPDATE GoodsSell SET gsNum = ?,commodityid = ?, merchandisingid = ? WHERE gsID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, goodsSell.getGsNum());
            pst.setLong(2, goodsSell.getCommodityid());
            pst.setLong(3,goodsSell.getMerchandisingid());
            pst.setLong(4, goodsSell.getGsID());
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
    public List<GoodsSell> select(GoodsSell goodsSell) {
        String sql="SELECT * FROM GoodsSell WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<GoodsSell>result=new ArrayList<GoodsSell>();
        if(goodsSell.getGsID()!=null){
            sql+=" and gsID ";
            params.add(goodsSell.getGsID());
        }
        if(goodsSell.getGsNum()!=null){
            sql+=" and gsNum ";
            params.add(goodsSell.getGsNum());
        }
        if(goodsSell.getCommodityid()!=null){
            sql+=" and commodityid ";
            params.add(goodsSell.getCommodityid());
        }
        if(goodsSell.getMerchandisingid()!=null){
            sql+=" and merchandisingid ";
            params.add(goodsSell.getMerchandisingid());
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
                GoodsSell b=new GoodsSell();
                b.setGsID(rs.getLong("gsID"));
                b.setGsNum(rs.getLong("gsNum"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setMerchandisingid(rs.getLong("merchandisingid"));
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

