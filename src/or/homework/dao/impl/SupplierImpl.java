package or.homework.dao.impl;

import or.homework.dao.ISupplierDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierImpl implements ISupplierDao {
    @Override
    public void add(Supplier supplier) {
        String sql = "INSERT INTO Supplier (supName,supAdds,supPhone,supAccount,supBank) VALUES (?,?,?,?,?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,supplier.getSupName());
            pst.setString(2,supplier.getSupAdds());
            pst.setLong(3,supplier.getSupPhone());
            pst.setLong(4, supplier.getSupAccount());
            pst.setString(5,supplier.getSupBank());
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
    public void delete(Supplier supplier) {
        String sql = "DELETE FROM Supplier WHERE supID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, supplier.getSupID());
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
    public void update(Supplier supplier) {
        String sql = "UPDATE Supplier SET supName = ?,supAdds = ?, supPhone = ?,supAccount = ?,supBank = ? WHERE supID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,supplier.getSupName());
            pst.setString(2,supplier.getSupAdds());
            pst.setLong(3,supplier.getSupPhone());
            pst.setLong(4,supplier.getSupAccount());
            pst.setString(5,supplier.getSupBank());
            pst.setLong(6,supplier.getSupID());
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
    public List<Supplier> select(Supplier supplier) {

        String sql="SELECT * FROM Supplier WHERE 1=1 ";
        List<Object>params=new ArrayList<Object>();
        List<Supplier>result=new ArrayList<Supplier>();
        if(supplier.getSupID()!=null){
            sql+=" and supID ";
            params.add(supplier.getSupID());
        }
        if(supplier.getSupName()!=null){
            sql+=" and supName ";
            params.add(supplier.getSupName());
        }
        if(supplier.getSupAdds()!=null){
            sql+=" and supAdds ";
            params.add(supplier.getSupAdds());
        }
        if(supplier.getSupPhone()!=null){
            sql+=" and supPhone ";
            params.add(supplier.getSupPhone());
        }
        if(supplier.getSupAccount()!=null){
            sql+=" and supAccount ";
            params.add(supplier.getSupID());
        }
        if(supplier.getSupBank()!=null){
            sql+=" and supBank ";
            params.add(supplier.getSupBank());
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
                Supplier b=new Supplier();
                b.setSupID(rs.getLong("supID"));
                b.setSupName(rs.getString("supName"));
                b.setSupAdds(rs.getString("supAdds"));
                b.setSupPhone(rs.getLong("supPhone"));
                b.setSupAccount(rs.getLong("supAccount"));
                b.setSupBank(rs.getString("supBank"));
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

