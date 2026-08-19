package com.taoye.labor_dispatch.mapper;

import com.taoye.labor_dispatch.entity.OrderInfo;
import com.taoye.labor_dispatch.entity.dto.OrderInfoDto;
import com.taoye.labor_dispatch.entity.vo.OrderInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    /**
     * 新增（只插入非空字段），主键回填到 row.id
     */
    int insertSelective(OrderInfo row);

    /**
     * 根据主键查询
     */
    OrderInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键更新（只更新非空字段）
     */
    int updateByPrimaryKeySelective(OrderInfo row);

    /**
     * 条件查询列表
     */
    List<OrderInfoVo> query(OrderInfoDto dto);

    /**
     * 条件查询数量
     */
    Integer queryCount(OrderInfoDto dto);
}
