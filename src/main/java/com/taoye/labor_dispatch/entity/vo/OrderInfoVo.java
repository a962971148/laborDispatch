package com.taoye.labor_dispatch.entity.vo;

import java.util.Date;
import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfoVo
 * @Description: 订单出参
 * @date 2026-08-19
 */
public class OrderInfoVo {

    private Long id;

    /**
     * 关联的订单详情列表
     */
    private List<OrderDetailVo> orderDetailList;

    private Long intialDescriptionId;

    private Date workDate;

    private Byte type;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDetailVo> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailVo> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Long getIntialDescriptionId() {
        return intialDescriptionId;
    }

    public void setIntialDescriptionId(Long intialDescriptionId) {
        this.intialDescriptionId = intialDescriptionId;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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
