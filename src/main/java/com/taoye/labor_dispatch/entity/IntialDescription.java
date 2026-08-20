package com.taoye.labor_dispatch.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author taoye
 * @since 2026-08-20
 */
@Getter
@Setter
@TableName("intial_description")
public class IntialDescription {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("intial_description")
    private String intialDescription;

    @TableField("group_affiliation")
    private String groupAffiliation;

    @TableField("upstream_labor_company_id")
    private Long upstreamLaborCompanyId;

    @TableField("wechat_number")
    private String wechatNumber;

    @TableField("remark")
    private String remark;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_delete")
    private Byte isDelete;

    /**
     * 微信号
     */
    @TableField("wechat_name")
    private String wechatName;

    /**
     * 公司名
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 岗位名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * 薪资范围
     */
    @TableField("salary")
    private String salary;

    /**
     * 工作地点，多个逗号分隔
     */
    @TableField("location")
    private String location;

    /**
     * 经验要求
     */
    @TableField("experience")
    private String experience;

    /**
     * 学历要求
     */
    @TableField("education")
    private String education;

    /**
     * 岗位职责
     */
    @TableField("duty")
    private String duty;

    /**
     * 任职要求
     */
    @TableField("requirement")
    private String requirement;

    /**
     * 福利待遇
     */
    @TableField("welfare")
    private String welfare;

    /**
     * 联系人
     */
    @TableField("contact")
    private String contact;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 类型：1日结 2小时工 3工作介绍 4进厂
     */
    @TableField("job_type")
    private Byte jobType;
}
