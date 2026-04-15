package com.taoye.labor_dispatch.config;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: ResultVo 
 * @Description: TODO() 
 * @date 2026-04-14 19:20
 */

import lombok.Data;

@Data
public class ResultVo<T> {

    // 响应码：200成功 500失败
    private Integer code;

    // 提示信息
    private String msg;

    // 数据体
    private T data;

    // ==================== 快速构建成功/失败 ====================
    public static <T> ResultVo<T> success() {
        return success(null);
    }

    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> vo = new ResultVo<>();
        vo.setCode(200);
        vo.setMsg("操作成功");
        vo.setData(data);
        return vo;
    }

    public static <T> ResultVo<T> error() {
        return error(500, "操作失败");
    }

    public static <T> ResultVo<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> ResultVo<T> error(Integer code, String msg) {
        ResultVo<T> vo = new ResultVo<>();
        vo.setCode(code);
        vo.setMsg(msg);
        vo.setData(null);
        return vo;
    }
}