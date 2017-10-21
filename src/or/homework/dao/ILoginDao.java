package or.homework.dao;

import or.homework.vo.Login;
import java.util.List;

public interface ILoginDao {
    public void add(Login login);
    public void delete(Login login);
    public void update(Login login);
    public List<Login> select(Login login);
    public List<Login> query(Login login);//查询员工的职称
}
