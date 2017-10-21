package or.homework.dao.impl;

import or.homework.dao.IMerchandisingDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Merchandising;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MerchandisingImpl implements IMerchandisingDao {
    @Override
    public void add(Merchandising merchandising) {
        String sql = "INSERT INTO Merchandising (mAmount,Profit,mDate) VALUES (?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,merchandising.getmAmount());
            pst.setLong(2,merchandising.getProfit());
            pst.setDate(3, (Date) merchandising.getmDate());
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
    public void delete(Merchandising merchandising) {
        String sql = "DELETE FROM Merchandising WHERE mID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,merchandising.getmID());
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
    public void update(Merchandising merchandising) {
        String sql = "UPDATE Merchandising SET mAmount = ?,Profit = ?, mDate = ? WHERE mID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, merchandising.getmAmount());
            pst.setLong(2, merchandising.getProfit());
            pst.setDate(3, (Date) merchandising.getmDate());
            pst.setLong(4, merchandising.getmID());
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
    public List<Merchandising> select(Merchandising merchandising) {
        String sql="SELECT * FROM Merchandising WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Merchandising>result=new ArrayList<Merchandising>();
        if(merchandising.getmID()!=null){
            sql+=" and mID ";
            params.add(merchandising.getmID());
        }
        if(merchandising.getmAmount()!=null){
            sql+=" and mAmount ";
            params.add(merchandising.getmAmount());
        }
        if(merchandising.getProfit()!=null){
            sql+=" and Profit ";
            params.add(merchandising.getProfit());
        }
        if(merchandising.getmDate()!=null){
            sql+=" and mDate ";
            params.add(merchandising.getmDate());
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
                Merchandising b=new Merchandising();
                b.setmID(rs.getLong("mID"));
                b.setmAmount(rs.getLong("mAmount"));
                b.setProfit(rs.getLong("Profit"));
                b.setmDate(rs.getDate("mDate"));
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
