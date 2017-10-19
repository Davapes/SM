package or.homework.dao;

import or.homework.vo.Put;

import java.util.List;

public interface IPutDao {
    public void add(Put put);
    public void delete(Put put);
    public void update(Put put);
    public List<Put> select(Put put);
}
