package or.homework.dao;

import or.homework.vo.Warehouse;

import java.util.List;

public interface IWarehouseDao {
    public void add(Warehouse warehouse);
    public void delete(Warehouse warehouse);
    public void update(Warehouse warehouse);
    public List<Warehouse> select(Warehouse warehouse);
    public List<Warehouse>query(Warehouse warehouse);
}
