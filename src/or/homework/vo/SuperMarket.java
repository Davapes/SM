package or.homework.vo;
//超市
public class SuperMarket {
    private Long smID;
    private String smName;
    private Long sID;
    private String smAdds;
    private Staff number;//员工对象
    public Long getsID() {
        return sID;
    }

    public void setsID(Long sID) {
        this.sID = sID;
    }
    public Long getSmID() {
        return smID;
    }

    public void setSmID(Long smID) {
        this.smID = smID;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public String getSmAdds() {
        return smAdds;
    }

    public void setSmAdds(String smAdds) {
        this.smAdds = smAdds;
    }
}
