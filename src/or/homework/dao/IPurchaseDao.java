package or.homework.dao;

import or.homework.vo.Purchase;

import java.util.List;

public interface IPurchaseDao {
    public void add(Purchase purchase);
    public void delete(Purchase purchase);
    public void update(Purchase purchase);
    public List<Purchase> select(Purchase purchase);
    public List<Purchase>query(Purchase purchase);//查询采购员信息
    public List<Purchase>queryone(Purchase purchase);//查询供应商
}
