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
 * 上游劳务公司表
 * </p>
 *
 * @author taoye
 * @since 2026-08-19
 */
@Getter
@Setter
@TableName("upstream_labor_company")
public class UpstreamLaborCompany {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 微信号
     */
    @TableField("wechat_number")
    private String wechatNumber;

    /**
     * 电话号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 联系人
     */
    @TableField("contact")
    private String contact;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 是否删除：0-未删除，1-已删除
     */
    @TableField("is_delete")
    private Byte isDelete;

    /**
     * 是否显示
     */
    @TableField("is_show")
    private Byte isShow;
}
