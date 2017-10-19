package or.homework.vo;

import java.util.Date;

public class Staff {
    private Long sID;
    private Long tId;
    private String sName;
    private String sSex;
    private Long sPhone;
    private Long sSalary;
    private Date sDate;
    private String sAdds;
    private String sProfessional;

    public Long getsID() {
        return sID;
    }

    public void setsID(Long sID) {
        this.sID = sID;
    }

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public Long getsPhone() {
        return sPhone;
    }

    public void setsPhone(Long sPhone) {
        this.sPhone = sPhone;
    }

    public Long getsSalary() {
        return sSalary;
    }

    public void setsSalary(Long sSalary) {
        this.sSalary = sSalary;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public String getsAdds() {
        return sAdds;
    }

    public void setsAdds(String sAdds) {
        this.sAdds = sAdds;
    }

    public String getsProfessional() {
        return sProfessional;
    }

    public void setsProfessional(String sProfessional) {
        this.sProfessional = sProfessional;
    }
}
