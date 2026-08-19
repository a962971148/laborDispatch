package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.UpstreamLaborCompanyDto;
import com.taoye.labor_dispatch.entity.vo.UpstreamLaborCompanyVo;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: UpstreamLaborCompanyService
 * @Description: 上游劳务公司服务
 * @date 2026-08-19
 */
public interface UpstreamLaborCompanyService {

    void save(UpstreamLaborCompanyDto dto);

    List<UpstreamLaborCompanyVo> list(UpstreamLaborCompanyDto dto);

    Integer count(UpstreamLaborCompanyDto dto);

    void update(UpstreamLaborCompanyDto dto);

    void delete(UpstreamLaborCompanyDto dto);
}
