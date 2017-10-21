package or.homework.dao.impl;

import or.homework.dao.ILoginDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Login;
import or.homework.vo.Staff;
import sun.rmi.runtime.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginImpl implements ILoginDao{
    @Override
    public void add(Login login) {
        String sql = "INSERT INTO Login (username,password,staffid) VALUES (?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,login.getUsername());
            pst.setString(2,login.getPassword());
            pst.setLong(3,login.getStaffid());
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
    public void delete(Login login) {
        String sql = "DELETE FROM Login WHERE id=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, login.getId());
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
    public void update(Login login) {
        String sql = "UPDATE Login SET username = ?,password = ?,staffid = ? WHERE id = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,login.getUsername());
            pst.setString(2, login.getPassword());
            pst.setLong(3,login.getStaffid());
            pst.setLong(4,login.getId());
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
    public List<Login> select(Login login) {
        String sql="SELECT * FROM Login WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Login>result=new ArrayList<Login>();
        if(login.getId()!=null){
            sql+=" and id ";
            params.add(login.getId());
        }
        if(login.getUsername()!=null){
            sql+=" and username ";
            params.add(login.getUsername());
        }
        if(login.getPassword()!=null){
            sql+=" and password ";
            params.add(login.getPassword());
        }
        if(login.getStaffid()!=null){
            sql+=" and staffid ";
            params.add(login.getStaffid());
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            for(int i=0;i<params.size();i++){
                if(params.get(i) instanceof Long){
                    pst.setLong(i+1, (Long)params.get(i));
                }else if(params.get(i) instanceof String){
                    pst.setString(i+1, (String) params.get(i));
                }
            }
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Login b=new Login();
                b.setId(rs.getLong("id"));
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setStaffid(rs.getLong("staffid"));
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
    public List<Login> query(Login login) {
        String sql = "SELECT username FROM Login AS L,Staff AS S WHERE L.id = S.sID";
        List<Object> params = new ArrayList<Object>();
        List<Login> result = new ArrayList<Login>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                Login b = new Login();
                Staff a = new Staff();
                a.setsProfessional(rs.getString("sProfessional"));
                b.setSid(a);
                result.add(b);
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
