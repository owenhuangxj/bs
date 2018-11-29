package com.ss.bookstore.entity;
import java.io.Serializable;
import java.math.BigDecimal;
public class Coupon implements Serializable {
    private static final long serialVersionUID = 2050691143561048756L;
    private Long couponId;
    private String couponName;
    private BigDecimal percentage;//优惠活动的百分比
    private String startTime;
    private String endTime;
    private BigDecimal fullReduceAmount;//满足满减的额度
    private BigDecimal fullDedution;//满足满减后的减少额

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getFullReduceAmount() {
        return fullReduceAmount;
    }

    public void setFullReduceAmount(BigDecimal fullReduceAmount) {
        this.fullReduceAmount = fullReduceAmount;
    }

    public BigDecimal getFullDedution() {
        return fullDedution;
    }

    public void setFullDedution(BigDecimal fullDedution) {
        this.fullDedution = fullDedution;
    }

    public Coupon() {
    }

    public Coupon(String couponName, BigDecimal percentage, String startTime, String endTime,
                  BigDecimal fullReduceAmount, BigDecimal fullDedution) {
        this.couponName = couponName;
        this.percentage = percentage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fullReduceAmount = fullReduceAmount;
        this.fullDedution = fullDedution;
    }

    @Override
    public String toString() {
        return "Coupon [couponId=" + couponId + ", couponName=" + couponName + ", percentage=" + percentage
                + ", startTime=" + startTime + ", endTime=" + endTime + ", fullReduceAmount=" + fullReduceAmount
                + ", fullDedution=" + fullDedution + "]";
    }

}
