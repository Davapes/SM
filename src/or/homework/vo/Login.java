package or.homework.vo;

public class Login {
    private String username;
    private String password;
    private Long staffid;
    private Staff sid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Staff getSid() {
        return sid;
    }

    public void setSid(Staff sid) {
        this.sid = sid;
    }
}
