package or.homework.dao.impl;

import or.homework.dao.ILoginDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Login;
import or.homework.vo.Staff;
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
        String sql = "DELETE FROM Login WHERE staffid=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, login.getStaffid());
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
        String sql = "UPDATE Login SET username = ?,password = ? WHERE staffid = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,login.getUsername());
            pst.setString(2, login.getPassword());
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
    public List<Login> select(Login login) {
        String sql="SELECT * FROM Login WHERE 1=1 ";
        List<Login>result=new ArrayList<Login>();
        if(login.getUsername()!=null&&login.getUsername()!=""){
            sql+=" and username = "+"'"+login.getUsername()+"'";

        }
        if(login.getPassword()!=null&&login.getPassword()!=""){
            sql+=" and password = "+"'"+login.getPassword()+"'";
        }
        if(login.getStaffid()!=null){
            sql+=" and staffid = "+"'"+login.getStaffid()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Login b=new Login();
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
