package or.homework.vo;
//入庫
public class Put {
    private Long putid;
    private Staff number;//仓库管理员编号
    private Staff num;//采购员编号
    private Commodity num;//商品id

    public Long getPutid() {
      return putid;
    }

    public void setPutid(Long putid) {
        this.putid = putid;
    }

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public Staff getNum() {
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

    public void setNum(Staff num) {
        this.num = num;
    }

    private Warehouse whnum;//仓库id
}
