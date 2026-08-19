package com.taoye.labor_dispatch.mapper;

import com.taoye.labor_dispatch.entity.OrderDetail;
import com.taoye.labor_dispatch.entity.dto.OrderDetailDto;
import com.taoye.labor_dispatch.entity.vo.OrderDetailVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    /**
     * 新增（只插入非空字段），主键回填到 row.id
     */
    int insertSelective(OrderDetail row);

    /**
     * 根据主键查询
     */
    OrderDetail selectByPrimaryKey(Long id);

    /**
     * 根据主键更新（只更新非空字段）
     */
    int updateByPrimaryKeySelective(OrderDetail row);

    /**
     * 条件查询列表
     */
    List<OrderDetailVo> query(OrderDetailDto dto);

    /**
     * 条件查询数量
     */
    Integer queryCount(OrderDetailDto dto);
}
