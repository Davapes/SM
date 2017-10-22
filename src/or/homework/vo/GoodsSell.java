package or.homework.vo;
//商品銷售表
public class GoodsSell {
    private Long gsID;
    private Long commodityid;
    private Long merchandisingid;
    private Long gsNum;//商品数量
    private Long gsje;//商品金额
    private Long gsylje;//商品盈利

    private Commodity num;//商品对象
    private Merchandising mnum;//销售单对象

    public Long getGsje() {
        return gsje;
    }

    public void setGsje(Long gsje) {
        this.gsje = gsje;
    }

    public Long getGsylje() {
        return gsylje;
    }

    public void setGsylje(Long gsylje) {
        this.gsylje = gsylje;
    }

    public Long getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Long commodityid) {
        this.commodityid = commodityid;
    }

    public Long getMerchandisingid() {
        return merchandisingid;
    }

    public void setMerchandisingid(Long merchandisingid) {
        this.merchandisingid = merchandisingid;
    }

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
