package or.homework.dao.impl;

import or.homework.dao.IGoodsSellDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.GoodsSell;
import or.homework.vo.Merchandising;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsSellImpl implements IGoodsSellDao {
    @Override
    public void add(GoodsSell goodsSell) {
        String sql = "INSERT INTO GoodsSell (commodityid,merchandisingid,gsNum,gsje,gsylje) VALUES (?.?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, goodsSell.getCommodityid());
            pst.setLong(2, goodsSell.getMerchandisingid());
            pst.setLong(3,goodsSell.getGsNum());
            pst.setLong(4, goodsSell.getGsje());
            pst.setLong(5, goodsSell.getGsylje());
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
        String sql = "UPDATE GoodsSell SET commodityid = ?, merchandisingid = ?,gsNum = ?,gsje = ?,gsylje = ? WHERE gsID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, goodsSell.getCommodityid());
            pst.setLong(2,goodsSell.getMerchandisingid());
            pst.setLong(3,goodsSell.getGsNum());
            pst.setLong(4, goodsSell.getGsje());
            pst.setLong(5,goodsSell.getGsylje());
            pst.setLong(6, goodsSell.getGsID());
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
            sql+=" and gsID = "+"'"+goodsSell.getGsID()+"'";
        }
        if(goodsSell.getCommodityid()!=null){
            sql+=" and commodityid = "+"'"+goodsSell.getCommodityid()+"'";
        }
        if(goodsSell.getMerchandisingid()!=null){
            sql+=" and merchandising = "+"'"+goodsSell.getMerchandisingid()+"'";
        }
        if(goodsSell.getGsNum()!=null){
            sql+=" and gsNum = "+"'"+goodsSell.getGsNum()+"'";
        }
        if(goodsSell.getGsje()!=null){
            sql+=" and gsje = "+"'"+goodsSell.getGsje()+"'";
        }
        if(goodsSell.getGsylje()!=null){
            sql+=" and gsylje = "+"'"+goodsSell.getGsylje()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                GoodsSell b=new GoodsSell();
                b.setGsID(rs.getLong("gsID"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setMerchandisingid(rs.getLong("merchandisingid"));
                b.setGsNum(rs.getLong("gsNum"));
                b.setGsje(rs.getLong("gsje"));
                b.setGsylje(rs.getLong("gsylje"));
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
    public List<GoodsSell> query(GoodsSell goodsSell) {
        String sql = "SELECT * FROM GoodsSell AS G,Commodity AS S WHERE G.gsID = S.cID";
        List<Object> params = new ArrayList<Object>();
        List<GoodsSell> result = new ArrayList<GoodsSell>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GoodsSell b = new GoodsSell();
                b.setGsID(rs.getLong("gsID"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setMerchandisingid(rs.getLong("merchandisingid"));
                b.setGsNum(rs.getLong("gsNum"));
                b.setGsje(rs.getLong("gsje"));
                b.setGsylje(rs.getLong("gsylje"));
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
    public List<GoodsSell> queryone(GoodsSell goodsSell) {
        String sql = "SELECT * FROM  GoodsSell AS G,Merchandising AS M WHERE G.gsID = M.mID";
        List<Object> params = new ArrayList<Object>();
        List<GoodsSell> result = new ArrayList<GoodsSell>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GoodsSell b = new GoodsSell();
                b.setGsID(rs.getLong("gsID"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setMerchandisingid(rs.getLong("merchandisingid"));
                b.setGsNum(rs.getLong("gsNum"));
                b.setGsje(rs.getLong("gsje"));
                b.setGsylje(rs.getLong("gsylje"));
                Merchandising a = new Merchandising();
                a.setmID(rs.getLong("mID"));
                a.setmAmount(rs.getLong("mAmount"));
                a.setProfit(rs.getLong("Profit"));
                a.setStaffid(rs.getLong("staffid"));
                a.setmDate(rs.getDate("mDate"));
                b.setMnum(a);
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

