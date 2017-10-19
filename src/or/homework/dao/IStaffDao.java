package or.homework.dao;

import or.homework.vo.Staff;

import java.util.List;

public interface IStaffDao {
    public void add(Staff staff);
    public void delete(Staff staff);
    public void update(Staff staff);
    public List<Staff> select(Staff staff);
}
