package or.homework.dao;

import or.homework.vo.Purchase;

import java.util.List;

public interface IPurchaseDao {
    public void add(Purchase purchase);
    public void delete(Purchase purchase);
    public void update(Purchase purchase);
    public List<Purchase> select(Purchase purchase);
}
