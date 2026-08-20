package com.taoye.labor_dispatch.mapper;

import com.taoye.labor_dispatch.entity.IntialDescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author taoye
 * @since 2026-08-20
 */
public interface IntialDescriptionMapper extends BaseMapper<IntialDescription> {
    List<IntialDescriptionVo> query(IntialDescriptionDto dto);

    Integer queryCount(IntialDescriptionDto intialDescriptionDto);
}
