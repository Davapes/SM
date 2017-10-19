package or.homework.dao;


import or.homework.vo.Commodity;


import java.util.List;

public interface ICommodityDao {
    public void add(Commodity commodity);
    public void delete(Commodity commodity);
    public void update(Commodity commodity);
    public List<Commodity> select(Commodity commodity);
}
