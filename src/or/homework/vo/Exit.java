package or.homework.vo;

import java.util.Date;
//出库类
public class Exit {
    private Long exitID;
    private Staff number;
    private SuperMarket serial;
    private Commodity num;
    private Warehouse whnum;
    private Date exitDate;
    private Long exitNum;

    public Long getExitID() {
        return exitID;
    }

    public void setExitID(Long exitID) {
        this.exitID = exitID;
    }

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public SuperMarket getSerial() {
        return serial;
    }

    public void setSerial(SuperMarket serial) {
        this.serial = serial;
    }

    public Commodity getNum() {
        return num;
    }

    public void setNum(Commodity num) {
        this.num = num;
    }

    public Warehouse getWhnum() {
        return whnum;
    }

    public void setWhnum(Warehouse whnum) {
        this.whnum = whnum;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Long getExitNum() {
        return exitNum;
    }

    public void setExitNum(Long exitNum) {
        this.exitNum = exitNum;
    }
}
