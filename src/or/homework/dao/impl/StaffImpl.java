package or.homework.dao.impl;

import or.homework.dao.IStaffDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffImpl implements IStaffDao {
    @Override
    public void add(Staff staff) {
        String sql = "INSERT INTO Staff (tID,sName,sSex,sPhone,sSalary,sDate,sAdds,sProfessional) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,staff.gettID());
            pst.setString(2,staff.getsName());
            pst.setString(3,staff.getsSex());
            pst.setLong(4,staff.getsPhone());
            pst.setLong(5,staff.getsSalary());
            pst.setDate(6, (Date) staff.getsDate());
            pst.setString(7, staff.getsAdds());
            pst.setString(8, staff.getsProfessional());
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
    public void delete(Staff staff) {
        String sql = "DELETE FROM Staff WHERE sID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, staff.getsID());
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
    public void update(Staff staff) {
        String sql = "UPDATE Staff SET tID = ?,sName = ?, sSex = ?,sPhone = ?,sSalary = ?,sDate = ?,sAdds = ?, sProfessional = ? WHERE sID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,staff.gettID());
            pst.setString(2,staff.getsName());
            pst.setString(3,staff.getsSex());
            pst.setLong(4,staff.getsPhone());
            pst.setLong(5,staff.getsSalary());
            pst.setDate(6, (Date) staff.getsDate());
            pst.setString(7,staff.getsAdds());
            pst.setString(8,staff.getsProfessional());
            pst.setLong(9,staff.getsID());
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
    public List<Staff> select(Staff staff) {
        String sql="SELECT * FROM Staff WHERE 1=1 ";
        List<Staff>result=new ArrayList<Staff>();
        if(staff.getsID()!=null){
            sql+=" and sID = "+"'"+staff.getsID()+"'";
        }
        if(staff.gettID()!=null){
            sql+=" and tID = "+"'"+staff.gettID()+"'";
        }
        if(staff.getsName()!=null&&staff.getsName()!=""){
            sql+=" and sName = "+"'"+staff.getsName()+"'";
        }
        if(staff.getsSex()!=null&&staff.getsSex()!=""){
            sql+=" and sSex = "+"'"+staff.getsSex()+"'";
        }
        if(staff.getsPhone()!=null){
            sql+=" and sPhone = "+"'"+staff.getsPhone()+"'";
        }
        if(staff.getsSalary()!=null){
            sql+=" and sSalary = "+"'"+staff.getsSalary()+"'";
        }
        if(staff.getsDate()!=null){
            sql+=" and sDate = "+"'"+staff.getsDate()+"'";
        }
        if(staff.getsAdds()!=null&&staff.getsAdds()!=""){
            sql+=" and sAdds = "+"'"+staff.getsAdds()+"'";
        }
        if(staff.getsProfessional()!=null&&staff.getsProfessional()!=""){
            sql+=" and sProfessional = "+"'"+staff.getsProfessional()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Staff b=new Staff();
                b.setsID(rs.getLong("sID"));
                b.settID(rs.getLong("tID"));
                b.setsName(rs.getString("sName"));
                b.setsSex(rs.getString("sSex"));
                b.setsPhone(rs.getLong("sPhone"));
                b.setsSalary(rs.getLong("sSalary"));
                b.setsDate(rs.getDate("sDate"));
                b.setsAdds(rs.getString("sAdds"));
                b.setsProfessional(rs.getString("sProfessional"));
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

