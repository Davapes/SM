package or.homework.dao;

import or.homework.vo.Exit;

import java.util.List;

public interface IExitDao {
    public void add(Exit exit);
    public void delete(Exit exit);
    public void update(Exit exit);
    public List<Exit> select(Exit exit);
}
