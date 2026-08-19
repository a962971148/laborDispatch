package com.taoye.labor_dispatch.entity.vo;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderDetailVo
 * @Description: 订单详情出参
 * @date 2026-08-19
 */
public class OrderDetailVo {

    private Long id;

    private Long orderId;

    private Long userId;

    private Date workDate;

    private LocalTime workStartTime;

    private LocalTime workEndTime;

    private Integer restDuration;

    private BigDecimal extraDeduction;

    private BigDecimal hourlyWage;

    private BigDecimal dailyWage;

    private Byte isSettled;

    private BigDecimal profit;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public LocalTime getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(LocalTime workStartTime) {
        this.workStartTime = workStartTime;
    }

    public LocalTime getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(LocalTime workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Integer getRestDuration() {
        return restDuration;
    }

    public void setRestDuration(Integer restDuration) {
        this.restDuration = restDuration;
    }

    public BigDecimal getExtraDeduction() {
        return extraDeduction;
    }

    public void setExtraDeduction(BigDecimal extraDeduction) {
        this.extraDeduction = extraDeduction;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public BigDecimal getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(BigDecimal dailyWage) {
        this.dailyWage = dailyWage;
    }

    public Byte getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(Byte isSettled) {
        this.isSettled = isSettled;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}
