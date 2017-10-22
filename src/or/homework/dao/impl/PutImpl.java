package or.homework.dao.impl;

import or.homework.dao.IPutDao;
import or.homework.util.ConnectJDBC;
import or.homework.vo.Commodity;
import or.homework.vo.Put;
import or.homework.vo.Staff;
import or.homework.vo.Warehouse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PutImpl implements IPutDao {
    @Override
    public void add(Put put) {
        String sql = "INSERT INTO Put (cangkuguanliid,supermarkid,commodityid,caigouid,warehouseid,putrq,putnum) VALUES (?,?,?,?.?.?.?)";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,put.getCangkuguanliid());
            pst.setLong(2,put.getSupermarkid());
            pst.setLong(3,put.getCommodityid());
            pst.setLong(4,put.getCaigouid());
            pst.setLong(5,put.getWarehouseid());
            pst.setDate(6, (Date) put.getPutrq());
            pst.setLong(7,put.getPutnum());
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
    public void delete(Put put) {
        String sql = "DELETE FROM Put WHERE putID=?";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1, put.getPutID());
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
    public void update(Put put) {
        String sql = "UPDATE Put SET cangkuguanliid = ?,supermarkid = ?, commodityid = ?,caigouid = ?,warehouseid = ?,putrq = ?,putnum = ? WHERE putID = ? ";
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setLong(1,put.getCangkuguanliid());
            pst.setLong(2,put.getSupermarkid());
            pst.setLong(3,put.getCommodityid());
            pst.setLong(4,put.getCaigouid());
            pst.setLong(5,put.getWarehouseid());
            pst.setDate(6, (Date) put.getPutrq());
            pst.setLong(7,put.getPutnum());
            pst.setLong(8,put.getPutID());
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
    public List<Put> select(Put put) {
        String sql="SELECT * FROM Put WHERE 1=1 ";
        List<Put>result=new ArrayList<Put>();
        if(put.getPutID()!=null){
            sql+=" and putID = "+"'"+put.getPutID()+"'";
        }
        if(put.getCangkuguanliid()!=null){
            sql+=" and cangkuguanliid = "+"'"+put.getCangkuguanliid()+"'";
        }
        if(put.getSupermarkid()!=null){
            sql+=" and supermarkid = "+"'"+put.getSupermarkid()+"'";
        }
        if(put.getCommodityid()!=null){
            sql+=" and commodityid = "+"'"+put.getCommodityid()+"'";
        }
        if(put.getCaigouid()!=null){
            sql+=" and caigouid = "+"'"+put.getCaigouid()+"'";
        }
        if(put.getWarehouseid()!=null){
            sql+=" and warehouseid = "+"'"+put.getWarehouseid()+"'";
        }
        if(put.getPutrq()!=null){
            sql+=" and putrq = "+"'"+put.getPutrq()+"'";
        }
        if(put.getPutnum()!=null){
            sql+=" and putnum = "+"'"+put.getPutnum()+"'";
        }
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Put b=new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setSupermarkid(rs.getLong("supermarkid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setCaigouid(rs.getLong("caigouid"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                b.setPutrq(rs.getDate("putrq"));
                b.setPutnum(rs.getLong("putnum"));
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
    public List<Put> query(Put exit) {
        String sql = "SELECT * FROM Put AS P,Staff AS S WHERE P.putID = S.sID";
        List<Object> params = new ArrayList<Object>();
        List<Put> result = new ArrayList<Put>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Put b = new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setSupermarkid(rs.getLong("supermarkid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setCaigouid(rs.getLong("caigouid"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                b.setPutrq(rs.getDate("putrq"));
                b.setPutnum(rs.getLong("putnum"));
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

    @Override
    public List<Put> queryone(Put put) {
        String sql = "SELECT * FROM Put AS P,Staff AS S WHERE P.putID = S.sID";
        List<Object> params = new ArrayList<Object>();
        List<Put> result = new ArrayList<Put>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Put b = new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setSupermarkid(rs.getLong("supermarkid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setCaigouid(rs.getLong("caigouid"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                b.setPutrq(rs.getDate("putrq"));
                b.setPutnum(rs.getLong("putnum"));
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

    @Override
    public List<Put> querytwo(Put put) {
        String sql = "SELECT * FROM Put AS P,Commodity AS C WHERE P.putID = C.cID";
        List<Object> params = new ArrayList<Object>();
        List<Put> result = new ArrayList<Put>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Put b = new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setSupermarkid(rs.getLong("supermarkid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setCaigouid(rs.getLong("caigouid"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                b.setPutrq(rs.getDate("putrq"));
                b.setPutnum(rs.getLong("putnum"));
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
                b.setWarehouseid(rs.getLong("warehouseid"));
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
    public List<Put> querythree(Put put) {
        String sql = "SELECT * FROM Put AS P,Warehouse AS W WHERE P.putID = W.whID";
        List<Object> params = new ArrayList<Object>();
        List<Put> result = new ArrayList<Put>();
        Connection conn = ConnectJDBC.getConn();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Put b = new Put();
                b.setPutID(rs.getLong("putID"));
                b.setCangkuguanliid(rs.getLong("cangkuguanliid"));
                b.setSupermarkid(rs.getLong("supermarkid"));
                b.setCommodityid(rs.getLong("commodityid"));
                b.setCaigouid(rs.getLong("caigouid"));
                b.setWarehouseid(rs.getLong("warehouseid"));
                b.setPutrq(rs.getDate("putrq"));
                b.setPutnum(rs.getLong("putnum"));
                Warehouse a = new Warehouse();
                a.setWhID(rs.getLong("whID"));
                a.setsID(rs.getLong("sID"));
                a.setWhName(rs.getString("whName"));
                a.setWhAddress(rs.getNString("whAddress"));
                a.setCapacity(rs.getLong("capacity"));
                a.setLeftCapacity(rs.getLong("leftCapacity"));
                b.setWhnum(a);
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

