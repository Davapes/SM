package or.homework.vo;
//超市
public class SuperMarket {
    private Long smID;
    private String smName;
    private String manger;//经理
    private String smAdds;

    public String getManger() {
        return manger;
    }

    public void setManger(String manger) {
        this.manger = manger;
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

    public String getSmAdds() {
        return smAdds;
    }

    public void setSmAdds(String smAdds) {
        this.smAdds = smAdds;
    }
}
