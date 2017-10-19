package or.homework.vo;
//商品采購
public class Procurement {
    private Long pid;
    private Commodity num;
    private Purchase pcnum;
    private Long pnum;

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
