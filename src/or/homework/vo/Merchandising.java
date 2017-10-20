package or.homework.vo;

import java.util.Date;

//銷售單
public class Merchandising {
    private Long mID;
    private Long mAmount;//销售金额
    private Long Profit;//盈利金额
    private Date mDate;

    public Long getmID() {
        return mID;
    }

    public void setmID(Long mID) {
        this.mID = mID;
    }

    public Long getmAmount() {
        return mAmount;
    }

    public void setmAmount(Long mAmount) {
        this.mAmount = mAmount;
    }

    public Long getProfit() {
        return Profit;
    }

    public void setProfit(Long profit) {
        Profit = profit;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}
