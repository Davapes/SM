package or.homework.vo;
//入庫
public class Put {
    private Long putID;
    private Long cangkuguanliid;
    private Long caigouid;
    private Long commodityid;
    private Long warehouseid;
    private Staff number;//仓库管理员对像
    private Staff snum;//采购员对象
    private Commodity num;//商品对象
    private Warehouse whnum;//仓库对象

    public Long getPutID() {
        return putID;
    }

    public void setPutID(Long putID) {
        this.putID = putID;
    }

    public Long getCangkuguanliid() {
        return cangkuguanliid;
    }

    public void setCangkuguanliid(Long cangkuguanliid) {
        this.cangkuguanliid = cangkuguanliid;
    }

    public Long getCaigouid() {
        return caigouid;
    }

    public void setCaigouid(Long caigouid) {
        this.caigouid = caigouid;
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

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public Staff getSnum() {
        return snum;
    }

    public void setSnum(Staff snum) {
        this.snum = snum;
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

}
