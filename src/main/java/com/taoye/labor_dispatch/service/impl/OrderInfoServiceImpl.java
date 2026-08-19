package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.config.IsDeleteEnum;
import com.taoye.labor_dispatch.entity.OrderDetail;
import com.taoye.labor_dispatch.entity.OrderInfo;
import com.taoye.labor_dispatch.entity.dto.OrderDetailDto;
import com.taoye.labor_dispatch.entity.dto.OrderInfoDto;
import com.taoye.labor_dispatch.entity.vo.OrderInfoVo;
import com.taoye.labor_dispatch.mapper.OrderDetailMapper;
import com.taoye.labor_dispatch.mapper.OrderInfoMapper;
import com.taoye.labor_dispatch.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfoServiceImpl
 * @Description: 订单服务实现
 * @date 2026-08-19
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public void save(OrderInfoDto dto) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setIntialDescriptionId(dto.getIntialDescriptionId());
        orderInfo.setWorkDate(dto.getWorkDate());
        orderInfo.setType(dto.getType());
        orderInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public List<OrderInfoVo> list(OrderInfoDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        return orderInfoMapper.query(dto);
    }

    @Override
    public Integer count(OrderInfoDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        return orderInfoMapper.queryCount(dto);
    }

    @Override
    public void update(OrderInfoDto dto) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(dto.getId());
        orderInfo.setIntialDescriptionId(dto.getIntialDescriptionId());
        orderInfo.setWorkDate(dto.getWorkDate());
        orderInfo.setType(dto.getType());
        orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }

    @Override
    public void delete(OrderInfoDto dto) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(dto.getId());
        orderInfo.setIsDelete(IsDeleteEnum.DELETED.getCode());
        orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWithDetails(OrderInfoDto dto) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setIntialDescriptionId(dto.getIntialDescriptionId());
        orderInfo.setWorkDate(dto.getWorkDate());
        orderInfo.setType(dto.getType());
        orderInfoMapper.insertSelective(orderInfo);

        if (!CollectionUtils.isEmpty(dto.getOrderDetailList())) {
            dto.getOrderDetailList().forEach(item -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(orderInfo.getId());
                orderDetail.setUserId(item.getUserId());
                orderDetail.setWorkDate(item.getWorkDate());
                orderDetail.setWorkStartTime(item.getWorkStartTime());
                orderDetail.setWorkEndTime(item.getWorkEndTime());
                orderDetail.setRestDuration(item.getRestDuration());
                orderDetail.setExtraDeduction(item.getExtraDeduction());
                orderDetail.setHourlyWage(item.getHourlyWage());
                orderDetail.setDailyWage(item.getDailyWage());
                orderDetail.setIsSettled(item.getIsSettled());
                orderDetail.setProfit(item.getProfit());
                orderDetailMapper.insertSelective(orderDetail);
            });
        }
    }

    @Override
    public List<OrderInfoVo> listWithDetails(OrderInfoDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        List<OrderInfoVo> voList = orderInfoMapper.query(dto);
        if (CollectionUtils.isEmpty(voList)) {
            return voList;
        }
        voList.forEach(vo -> {
            OrderDetailDto detailDto = new OrderDetailDto();
            detailDto.setOrderId(vo.getId());
            detailDto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
            vo.setOrderDetailList(orderDetailMapper.query(detailDto));
        });
        return voList;
    }
}
