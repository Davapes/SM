package or.homework.vo;

import java.util.Date;
//采购类
public class Purchase {
    private Long pchID;
    private Long pchMoney;
    private Date pchDate;
    private Long staffid;
    private Long supplierid;
    private Staff number;//采购员对象
    private Supplier numeration;//供应商对象
    public Long getStaffid() {
        return staffid;
    }

    public void setStaffid(Long staffid) {
        this.staffid = staffid;
    }

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    public Long getPchID() {
        return pchID;
    }

    public void setPchID(Long pchID) {
        this.pchID = pchID;
    }

    public Long getPchMoney() {
        return pchMoney;
    }

    public void setPchMoney(Long pchMoney) {
        this.pchMoney = pchMoney;
    }

    public Date getPchDate() {
        return pchDate;
    }

    public void setPchDate(Date pchDate) {
        this.pchDate = pchDate;
    }

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public Supplier getNumeration() {
        return numeration;
    }

    public void setNumeration(Supplier numeration) {
        this.numeration = numeration;
    }
}
