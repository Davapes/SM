package or.homework.dao;

import or.homework.vo.Merchandising;

import java.util.List;

public interface IMerchandisingDao {
    public void add(Merchandising merchandising);
    public void delete(Merchandising merchandising);
    public void update(Merchandising merchandising);
    public List<Merchandising> select(Merchandising merchandising);
}
