package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.OrderDetailDto;
import com.taoye.labor_dispatch.entity.vo.OrderDetailVo;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderDetailService
 * @Description: 订单详情服务
 * @date 2026-08-19
 */
public interface OrderDetailService {

    void save(OrderDetailDto dto);

    List<OrderDetailVo> list(OrderDetailDto dto);

    Integer count(OrderDetailDto dto);

    void update(OrderDetailDto dto);

    void delete(OrderDetailDto dto);
}
