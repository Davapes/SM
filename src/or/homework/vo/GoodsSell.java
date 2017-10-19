package or.homework.vo;
//商品銷售表
public class GoodsSell {
    private Long gsID;
    private Commodity num;//商品id
    private Merchandising mnum;//销售单id
    private Long gsNum;

    public Long getGsID() {
        return gsID;
    }

    public void setGsID(Long gsID) {
        this.gsID = gsID;
    }

    public Commodity getNum() {
        return num;
    }

    public void setNum(Commodity num) {
        this.num = num;
    }

    public Merchandising getMnum() {
        return mnum;
    }

    public void setMnum(Merchandising mnum) {
        this.mnum = mnum;
    }

    public Long getGsNum() {
        return gsNum;
    }

    public void setGsNum(Long gsNum) {
        this.gsNum = gsNum;
    }
}
