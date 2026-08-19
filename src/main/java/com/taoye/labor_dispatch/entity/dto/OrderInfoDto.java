package com.taoye.labor_dispatch.entity.dto;

import java.util.Date;
import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfoDto
 * @Description: 订单入参
 * @date 2026-08-19
 */
public class OrderInfoDto {

    private Long id;

    /**
     * 订单详情列表（新建/更新时关联多个 order_detail）
     */
    private List<OrderDetailDto> orderDetailList;

    private Long intialDescriptionId;

    private Date workDate;

    private Byte type;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    private Integer pageNum = 1;   // 默认第1页
    private Integer pageSize = 10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderDetailDto> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailDto> orderDetailList) {
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
