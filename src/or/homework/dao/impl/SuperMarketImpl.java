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
        String sql = "INSERT INTO SuperMarket (smName,sID,smAdds) VALUES (?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,superMarket.getSmName());
            pst.setLong(2,superMarket.getsID());
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
        String sql = "UPDATE SuperMarket SET smName = ?,sID = ?, smAdds = ? WHERE smID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,superMarket.getSmName());
            pst.setLong(2,superMarket.getsID());
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
        List<Object>params=new ArrayList<Object>();
        List<SuperMarket>result=new ArrayList<SuperMarket>();
        if(superMarket.getSmID()!=null){
            sql+=" and smID ";
            params.add(superMarket.getSmID());
        }
        if(superMarket.getSmName()!=null){
            sql+=" and smName ";
            params.add(superMarket.getSmID());
        }
        if(superMarket.getsID()!=null){
            sql+=" and sID ";
            params.add(superMarket.getSmID());
        }
        if(superMarket.getSmAdds()!=null){
            sql+=" and smAdds ";
            params.add(superMarket.getSmAdds());
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for(int i=0;i<params.size();i++){
                if(params.get(i) instanceof Long){
                    pst.setLong(i+1, (Long)params.get(i));
                }else if(params.get(i) instanceof String){
                    pst.setString(i+1, (String)params.get(i));
                }
            }
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                SuperMarket b=new SuperMarket();
                b.setSmID(rs.getLong("smID"));
                b.setSmName(rs.getString("smName"));
                b.setsID(rs.getLong("sID"));
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
        return null;
    }
}

