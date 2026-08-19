package com.taoye.labor_dispatch.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderDetail
 * @Description: 订单详情实体，对应表 order_detail
 * @date 2026-08-19
 */
public class OrderDetail {

    /**
     * 主键，对应数据库列 order_detail.id
     */
    private Long id;

    /**
     * 订单ID（关联 order_info 表），对应数据库列 order_detail.order_id
     */
    private Long orderId;

    /**
     * 用户ID（关联 user_info 表），对应数据库列 order_detail.user_id
     */
    private Long userId;

    /**
     * 工作日期，对应数据库列 order_detail.work_date
     */
    private Date workDate;

    /**
     * 工作开始时间，对应数据库列 order_detail.work_start_time
     */
    private LocalTime workStartTime;

    /**
     * 工作结束时间，对应数据库列 order_detail.work_end_time
     */
    private LocalTime workEndTime;

    /**
     * 休息时长（分钟），对应数据库列 order_detail.rest_duration
     */
    private Integer restDuration;

    /**
     * 另外扣费，对应数据库列 order_detail.extra_deduction
     */
    private BigDecimal extraDeduction;

    /**
     * 时薪，对应数据库列 order_detail.hourly_wage
     */
    private BigDecimal hourlyWage;

    /**
     * 日薪，对应数据库列 order_detail.daily_wage
     */
    private BigDecimal dailyWage;

    /**
     * 是否结单：0-未结单，1-已结单，对应数据库列 order_detail.is_settled
     */
    private Byte isSettled;

    /**
     * 盈利（可为负），对应数据库列 order_detail.profit
     */
    private BigDecimal profit;

    /**
     * 创建时间，对应数据库列 order_detail.create_time
     */
    private Date createTime;

    /**
     * 修改时间，对应数据库列 order_detail.update_time
     */
    private Date updateTime;

    /**
     * 是否删除：0-未删除，1-已删除，对应数据库列 order_detail.is_delete
     */
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
