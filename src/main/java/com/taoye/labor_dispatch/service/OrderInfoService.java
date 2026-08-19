package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.OrderInfoDto;
import com.taoye.labor_dispatch.entity.vo.OrderInfoVo;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfoService
 * @Description: 订单服务
 * @date 2026-08-19
 */
public interface OrderInfoService {

    void save(OrderInfoDto dto);

    List<OrderInfoVo> list(OrderInfoDto dto);

    Integer count(OrderInfoDto dto);

    void update(OrderInfoDto dto);

    void delete(OrderInfoDto dto);

    /**
     * 新建订单（关联多个订单详情）
     */
    void saveWithDetails(OrderInfoDto dto);

    /**
     * 查询订单（带关联的订单详情列表）
     */
    List<OrderInfoVo> listWithDetails(OrderInfoDto dto);
}
