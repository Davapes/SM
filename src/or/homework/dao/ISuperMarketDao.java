package or.homework.dao;

import or.homework.vo.SuperMarket;

import java.util.List;

public interface ISuperMarketDao {
    public void add(SuperMarket superMarket);
    public void delete(SuperMarket superMarket);
    public void update(SuperMarket superMarket);
    public List<SuperMarket> select(SuperMarket superMarket);
}
