package com.taoye.labor_dispatch.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IsDeleteEnum {

    /**
     * 未删除
     */
    NORMAL((byte)0, "未删除"),

    /**
     * 已删除
     */
    DELETED((byte)1, "已删除");

    private final Byte code;
    private final String desc;
}