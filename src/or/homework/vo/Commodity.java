package or.homework.vo;

import java.util.Date;

//商品
public class Commodity {
    private Long cID;//id
    private String cName;//名字
    private String units;//单位
    private String origin;//产地
    private String brand;//商标
    private Long cprice;//价格
    private Long jinjia;//进价
    private Date cgrq;//采购日期
    private Long supplierid;//供应商id
    private String baozhiqi;//保质期
    private Long warehouseid;//仓库id

    private Supplier s;//供应商对象
    private Warehouse w;//仓库对象
    public Long getcID() {
        return cID;
    }

    public Long getCprice() {
        return cprice;
    }

    public void setCprice(Long cprice) {
        this.cprice = cprice;
    }

    public Long getJinjia() {
        return jinjia;
    }

    public void setJinjia(Long jinjia) {
        this.jinjia = jinjia;
    }

    public Date getCgrq() {
        return cgrq;
    }

    public void setCgrq(Date cgrq) {
        this.cgrq = cgrq;
    }

    public Long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Long supplierid) {
        this.supplierid = supplierid;
    }

    public String getBaozhiqi() {
        return baozhiqi;
    }

    public void setBaozhiqi(String baozhiqi) {
        this.baozhiqi = baozhiqi;
    }

    public Long getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Long warehouseid) {
        this.warehouseid = warehouseid;
    }

    public Supplier getS() {
        return s;
    }

    public void setS(Supplier s) {
        this.s = s;
    }

    public Warehouse getW() {
        return w;
    }

    public void setW(Warehouse w) {
        this.w = w;
    }

    public void setcID(Long cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
