package or.homework.dao.impl;

import or.homework.dao.ISuperMarketDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.SuperMarket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperMarketImpl implements ISuperMarketDao {
    @Override
    public void add(SuperMarket superMarket) {
        String sql = "INSERT INTO SuperMarket (smName,manger,smAdds) VALUES (?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,superMarket.getSmName());
            pst.setString(2,superMarket.getManger());
            pst.setString(3,superMarket.getSmAdds());
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
    public void delete(SuperMarket superMarket) {
        String sql = "DELETE FROM SuperMarket WHERE smID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,superMarket.getSmID());
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
    public void update(SuperMarket superMarket) {
        String sql = "UPDATE SuperMarket SET smName = ?,manger = ?, smAdds = ? WHERE smID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,superMarket.getSmName());
            pst.setString(2,superMarket.getManger());
            pst.setString(3,superMarket.getSmAdds());
            pst.setLong(4,superMarket.getSmID());
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
    public List<SuperMarket> select(SuperMarket superMarket) {
        String sql="SELECT * FROM SuperMarket WHERE 1=1 ";
        List<SuperMarket>result=new ArrayList<SuperMarket>();
        if(superMarket.getSmID()!=null){
            sql+=" and smID = "+"'"+superMarket.getSmID()+"'";
        }
        if(superMarket.getSmName()!=null&&superMarket.getSmName()!=""){
            sql+=" and smName = "+"'"+superMarket.getSmName()+"'";
        }
        if(superMarket.getManger()!=null&&superMarket.getManger()!=""){
            sql+=" and manger = "+"'"+superMarket.getManger()+"'";
        }
        if(superMarket.getSmAdds()!=null&&superMarket.getSmAdds()!=""){
            sql+=" and smAdds = "+"'"+superMarket.getSmAdds()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                SuperMarket b=new SuperMarket();
                b.setSmID(rs.getLong("smID"));
                b.setSmName(rs.getString("smName"));
                b.setManger(rs.getString("manger"));
                b.setSmAdds(rs.getString("smAdds"));
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

