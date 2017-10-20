package or.homework.dao.impl;

import or.homework.dao.IExitDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Exit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExitImpl implements IExitDao {
    @Override
    public void add(Exit exit) {
        String sql = "INSERT INTO Exit (number,serial,num,whnum,exitDate,exitNum) VALUES (?,?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,exit.getSerial());
            pst.setString(2,exit.getNum());
            pst.setString(3, exit.getWhnum());
            pst.setString(4, exit.getExitDate());
            pst.setString(5,exit.getExitNum());
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
    public void delete(Exit exit) {
        String sql = "DELETE FROM Exit WHERE exitID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, exit.getExitID());
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
    public void update(Exit exit) {
        String sql = "UPDATE Exit SET serial = ?,num = ?,whnum = ?,exitDate = ?,exitNum = ? WHERE cID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, exit.getExitID());
            pst.setString(2, exit.getSerial());
            pst.setString(3,exit.getNum());
            pst.setString(4, exit.getWhnum());
            pst.setString(5,exit.getExitDate());
            pst.setString(6,exit.getExitNum());
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
    public List<Exit> select(Exit exit) {
        return null;
    }
}
