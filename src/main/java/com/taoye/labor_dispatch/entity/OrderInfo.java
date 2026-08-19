package com.taoye.labor_dispatch.entity;

import java.util.Date;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfo
 * @Description: 订单实体，对应表 order_info
 * @date 2026-08-19
 */
public class OrderInfo {

    /**
     * 主键，对应数据库列 order_info.id
     */
    private Long id;

    /**
     * 初始描述ID（关联 intial_description 表），对应数据库列 order_info.intial_description_id
     */
    private Long intialDescriptionId;

    /**
     * 工作日期，对应数据库列 order_info.work_date
     */
    private Date workDate;

    /**
     * 类型：1-日结，2-进厂，3-小时工，4-推荐工作，对应数据库列 order_info.type
     */
    private Byte type;

    /**
     * 创建时间，对应数据库列 order_info.create_time
     */
    private Date createTime;

    /**
     * 修改时间，对应数据库列 order_info.update_time
     */
    private Date updateTime;

    /**
     * 是否删除：0-未删除，1-已删除，对应数据库列 order_info.is_delete
     */
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
