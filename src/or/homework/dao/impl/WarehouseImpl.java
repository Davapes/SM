package or.homework.dao.impl;

import or.homework.dao.IWarehouseDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Staff;
import or.homework.vo.Warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseImpl implements IWarehouseDao {
    @Override
    public void add(Warehouse warehouse) {
        String sql = "INSERT INTO Warehouse (sID,whName,whAddress,capacity,leftCapacity) VALUES (?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, warehouse.getsID());
            pst.setString(2, warehouse.getWhName());
            pst.setString(3, warehouse.getWhAddress());
            pst.setLong(4, warehouse.getCapacity());
            pst.setLong(5, warehouse.getLeftCapacity());
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
    public void delete(Warehouse warehouse) {
        String sql = "DELETE FROM Warehouse WHERE whID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, warehouse.getWhID());
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
    public void update(Warehouse warehouse) {
        String sql = "UPDATE Warehouae SET sID = ?,whName = ?, whAdress = ?,capacity = ?,leftCapacity = ? WHERE whID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, warehouse.getsID());
            pst.setString(2, warehouse.getWhName());
            pst.setString(3, warehouse.getWhAddress());
            pst.setLong(4, warehouse.getCapacity());
            pst.setLong(5, warehouse.getLeftCapacity());
            pst.setLong(6, warehouse.getWhID());
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
    public List<Warehouse> select(Warehouse warehouse) {
        String sql = "SELECT * FROM Commodity WHERE 1=1 ";
        List<Warehouse> result = new ArrayList<Warehouse>();
        if (warehouse.getWhID() != null) {
            sql+=" and whID = "+"'"+warehouse.getWhID()+"'";
        }
        if (warehouse.getsID() != null) {
            sql+=" and sID = "+"'"+warehouse.getsID()+"'";
        }
        if (warehouse.getWhName() != null&&warehouse.getWhName()!="") {
            sql+=" and whName = "+"'"+warehouse.getWhName()+"'";
        }
        if (warehouse.getWhAddress() != null&&warehouse.getWhAddress()!="") {
            sql+=" and whAddress = "+"'"+warehouse.getWhAddress()+"'";
        }
        if (warehouse.getCapacity() != null) {
            sql+=" and capacity = "+"'"+warehouse.getCapacity()+"'";
        }
        if (warehouse.getLeftCapacity() != null) {
            sql+=" and leftCapacity = "+"'"+warehouse.getLeftCapacity()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Warehouse b = new Warehouse();
                b.setWhID(rs.getLong("whID"));
                b.setsID(rs.getLong("sID"));
                b.setWhName(rs.getString("whName"));
                b.setWhAddress(rs.getString("whAddress"));
                b.setCapacity(rs.getLong("capacity"));
                b.setLeftCapacity(rs.getLong("leftCapacity"));
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
    public List<Warehouse> query(Warehouse warehouse) {
        String sql = "SELECT * FROM Warehouse AS W,Staff AS S WHERE W.sID = S.sID";
        List<Object> params = new ArrayList<Object>();
        List<Warehouse> result = new ArrayList<>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                    Warehouse b = new Warehouse();
                    b.setWhID(rs.getLong("whID"));
                    b.setsID(rs.getLong("sID"));
                    b.setWhName(rs.getString("whName"));
                    b.setWhAddress(rs.getString("whAddress"));
                    b.setCapacity(rs.getLong("capacity"));
                    b.setLeftCapacity(rs.getLong("leftCapacity"));
                    Staff a = new Staff();
                    a.setsID(rs.getLong("sID"));
                    a.settID(rs.getLong("tID"));
                    a.setsName(rs.getString("sName"));
                    a.setsSex(rs.getNString("sSex"));
                    a.setsPhone(rs.getLong("sPhone"));
                    a.setsSalary(rs.getLong("sSalary"));
                    a.setsDate(rs.getDate("sDate"));
                    a.setsAdds(rs.getString("sAdds"));
                    a.setsProfessional(rs.getString("sProfessional"));
                    b.setNumber(a);
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

