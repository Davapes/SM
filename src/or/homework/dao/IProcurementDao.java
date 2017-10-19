package or.homework.dao;

import or.homework.vo.Procurement;

import java.util.List;

public interface IProcurementDao {
    public void add(Procurement procurement);
    public void delete(Procurement procurement);
    public void update(Procurement procurement);
    public List<Procurement> select(Procurement procurement);
}
