package or.homework.dao;

import or.homework.vo.Put;

import java.util.List;

public interface IPutDao {
    public void add(Put put);
    public void delete(Put put);
    public void update(Put put);
    public List<Put> select(Put put);
    public List<Put>query(Put exit);//查询采购员信息
    public List<Put>queryone(Put put);//查询仓库管理员信息
    public List<Put>querytwo(Put put);//查询商品信息
    public List<Put>querythree(Put put);//查询仓库信息
}
