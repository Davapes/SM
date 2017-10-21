package or.homework.dao;

import or.homework.vo.GoodsSell;

import java.util.List;

public interface IGoodsSellDao {
    public void add(GoodsSell goodsSell);
    public void delete(GoodsSell goodsSell);
    public void update(GoodsSell goodsSell);
    public List<GoodsSell> select(GoodsSell goodsSell);
    public List<GoodsSell>query(GoodsSell goodsSell);//查询商品信息
    public List<GoodsSell>queryone(GoodsSell goodsSell);//查询销售单信息
}
