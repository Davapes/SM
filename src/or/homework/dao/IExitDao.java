package or.homework.dao;

import or.homework.vo.Exit;

import java.util.List;

public interface IExitDao {
    public void add(Exit exit);
    public void delete(Exit exit);
    public void update(Exit exit);
    public List<Exit> select(Exit exit);
    public List<Exit>query(Exit exit);//查询采购员信息
    public List<Exit>queryone(Exit exit);//查询仓库管理员信息
    public List<Exit>querytwo(Exit exit);//查询商品信息
    public List<Exit>querythree(Exit exit);//查询仓库信息
}
