package or.homework.vo;
//商品采購
public class Procurement {
    private Long pid;
    private Long commodityid;
    private Long purchaseid;
    private Long pnum;//采购数量
    private Long pje;//采购金额

    private Commodity num;
    private Purchase pcnum;

    public Long getPje() {
        return pje;
    }

    public void setPje(Long pje) {
        this.pje = pje;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Long getPurchaseid() {
        return purchaseid;
    }

    public void setPurchaseid(Long purchaseid) {
        this.purchaseid = purchaseid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Commodity getNum() {
        return num;
    }

    public void setNum(Commodity num) {
        this.num = num;
    }

    public Purchase getPcnum() {
        return pcnum;
    }

    public void setPcnum(Purchase pcnum) {
        this.pcnum = pcnum;
    }

    public Long getPnum() {
        return pnum;
    }

    public void setPnum(Long pnum) {
        this.pnum = pnum;
    }
}
