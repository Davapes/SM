package or.homework.dao;

import or.homework.vo.Supplier;

import java.util.List;

public interface ISupplierDao {
    public void add(Supplier supplier);
    public void delete(Supplier supplier);
    public void update(Supplier supplier);
    public List<Supplier> select(Supplier supplier);
}
