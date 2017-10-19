package or.homework.vo;
//仓库类
public class Warehouse {
    private Long whID;
    private Staff number;
    private String whName;
    private String whAddress;
    private Long capacity;//仓库容量
    private Long leftCapacity;//仓库剩余容量

    public Long getWhID() {
        return whID;
    }

    public void setWhID(Long whID) {
        this.whID = whID;
    }

    public Staff getNumber() {
        return number;
    }

    public void setNumber(Staff number) {
        this.number = number;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhAddress() {
        return whAddress;
    }

    public void setWhAddress(String whAddress) {
        this.whAddress = whAddress;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getLeftCapacity() {
        return leftCapacity;
    }

    public void setLeftCapacity(Long leftCapacity) {
        this.leftCapacity = leftCapacity;
    }
}
