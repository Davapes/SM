package or.homework.vo;

import java.util.Date;
//出库类
public class Exit {
    private Long exitID;
    private Long staffid;
    private Long snumation;
    private Long commodityid;
    private Long warehouseid;
    private Date exitDate;
    private Long exitNum;
    private Staff number;
    private Staff numation;
    private Commodity num;
    private Warehouse whnum;

    public Long getSnumation() {
        return snumation;
    }

    public void setSnumation(Long snumation) {
        this.snumation = snumation;
    }

    public Staff getNumation() {
        return numation;
    }

    public void setNumation(Staff numation) {
        this.numation = numation;
    }

    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Long getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Long warehouseid) {
        this.warehouseid = warehouseid;
    }

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
