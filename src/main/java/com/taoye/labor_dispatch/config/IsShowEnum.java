package com.taoye.labor_dispatch.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IsShowEnum {

    /**
     * 未删除
     */
    SHOW((byte)1, "显示"),

    /**
     * 已删除
     */
    NOWT_SHOW((byte)0, "不显示");

    private final Byte code;
    private final String desc;
}
