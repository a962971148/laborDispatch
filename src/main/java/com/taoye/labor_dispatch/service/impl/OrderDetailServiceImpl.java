package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.config.IsDeleteEnum;
import com.taoye.labor_dispatch.entity.OrderDetail;
import com.taoye.labor_dispatch.entity.dto.OrderDetailDto;
import com.taoye.labor_dispatch.entity.vo.OrderDetailVo;
import com.taoye.labor_dispatch.mapper.OrderDetailMapper;
import com.taoye.labor_dispatch.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderDetailServiceImpl
 * @Description: 订单详情服务实现
 * @date 2026-08-19
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public void save(OrderDetailDto dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(dto.getOrderId());
        orderDetail.setUserId(dto.getUserId());
        orderDetail.setWorkDate(dto.getWorkDate());
        orderDetail.setWorkStartTime(dto.getWorkStartTime());
        orderDetail.setWorkEndTime(dto.getWorkEndTime());
        orderDetail.setRestDuration(dto.getRestDuration());
        orderDetail.setExtraDeduction(dto.getExtraDeduction());
        orderDetail.setHourlyWage(dto.getHourlyWage());
        orderDetail.setDailyWage(dto.getDailyWage());
        orderDetail.setIsSettled(dto.getIsSettled());
        orderDetail.setProfit(dto.getProfit());
        orderDetailMapper.insertSelective(orderDetail);
    }

    @Override
    public List<OrderDetailVo> list(OrderDetailDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        return orderDetailMapper.query(dto);
    }

    @Override
    public Integer count(OrderDetailDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        return orderDetailMapper.queryCount(dto);
    }

    @Override
    public void update(OrderDetailDto dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(dto.getId());
        orderDetail.setOrderId(dto.getOrderId());
        orderDetail.setUserId(dto.getUserId());
        orderDetail.setWorkDate(dto.getWorkDate());
        orderDetail.setWorkStartTime(dto.getWorkStartTime());
        orderDetail.setWorkEndTime(dto.getWorkEndTime());
        orderDetail.setRestDuration(dto.getRestDuration());
        orderDetail.setExtraDeduction(dto.getExtraDeduction());
        orderDetail.setHourlyWage(dto.getHourlyWage());
        orderDetail.setDailyWage(dto.getDailyWage());
        orderDetail.setIsSettled(dto.getIsSettled());
        orderDetail.setProfit(dto.getProfit());
        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public void delete(OrderDetailDto dto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(dto.getId());
        orderDetail.setIsDelete(IsDeleteEnum.DELETED.getCode());
        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }
}
