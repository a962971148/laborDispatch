package com.taoye.labor_dispatch.mapper;

import com.taoye.labor_dispatch.entity.UpstreamLaborCompany;
import com.taoye.labor_dispatch.entity.dto.UpstreamLaborCompanyDto;
import com.taoye.labor_dispatch.entity.vo.UpstreamLaborCompanyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpstreamLaborCompanyMapper {

    /**
     * 新增（只插入非空字段），主键回填到 row.id
     */
    int insertSelective(UpstreamLaborCompany row);

    /**
     * 根据主键查询
     */
    UpstreamLaborCompany selectByPrimaryKey(Long id);

    /**
     * 根据主键更新（只更新非空字段）
     */
    int updateByPrimaryKeySelective(UpstreamLaborCompany row);

    /**
     * 条件查询列表
     */
    List<UpstreamLaborCompanyVo> query(UpstreamLaborCompanyDto dto);

    /**
     * 条件查询数量
     */
    Integer queryCount(UpstreamLaborCompanyDto dto);
}
