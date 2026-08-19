package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.config.IsDeleteEnum;
import com.taoye.labor_dispatch.config.IsShowEnum;
import com.taoye.labor_dispatch.entity.UpstreamLaborCompany;
import com.taoye.labor_dispatch.entity.dto.UpstreamLaborCompanyDto;
import com.taoye.labor_dispatch.entity.vo.UpstreamLaborCompanyVo;
import com.taoye.labor_dispatch.mapper.UpstreamLaborCompanyMapper;
import com.taoye.labor_dispatch.service.UpstreamLaborCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: UpstreamLaborCompanyServiceImpl
 * @Description: 上游劳务公司服务实现
 * @date 2026-08-19
 */
@Service
public class UpstreamLaborCompanyServiceImpl implements UpstreamLaborCompanyService {

    @Autowired
    UpstreamLaborCompanyMapper upstreamLaborCompanyMapper;

    @Override
    public void save(UpstreamLaborCompanyDto dto) {
        UpstreamLaborCompany upstreamLaborCompany = new UpstreamLaborCompany();
        upstreamLaborCompany.setWechatNumber(dto.getWechatNumber());
        upstreamLaborCompany.setPhone(dto.getPhone());
        upstreamLaborCompany.setCompanyName(dto.getCompanyName());
        upstreamLaborCompany.setContact(dto.getContact());
        upstreamLaborCompanyMapper.insertSelective(upstreamLaborCompany);
    }

    @Override
    public List<UpstreamLaborCompanyVo> list(UpstreamLaborCompanyDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        dto.setIsShow(IsShowEnum.SHOW.getCode());
        return upstreamLaborCompanyMapper.query(dto);
    }

    @Override
    public Integer count(UpstreamLaborCompanyDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        return upstreamLaborCompanyMapper.queryCount(dto);
    }

    @Override
    public void update(UpstreamLaborCompanyDto dto) {
        UpstreamLaborCompany upstreamLaborCompany = new UpstreamLaborCompany();
        upstreamLaborCompany.setId(dto.getId());
        upstreamLaborCompany.setWechatNumber(dto.getWechatNumber());
        upstreamLaborCompany.setPhone(dto.getPhone());
        upstreamLaborCompany.setCompanyName(dto.getCompanyName());
        upstreamLaborCompany.setContact(dto.getContact());
        upstreamLaborCompanyMapper.updateByPrimaryKeySelective(upstreamLaborCompany);
    }

    @Override
    public void delete(UpstreamLaborCompanyDto dto) {
        UpstreamLaborCompany upstreamLaborCompany = new UpstreamLaborCompany();
        upstreamLaborCompany.setId(dto.getId());
        upstreamLaborCompany.setIsDelete(IsDeleteEnum.DELETED.getCode());
        upstreamLaborCompanyMapper.updateByPrimaryKeySelective(upstreamLaborCompany);
    }
}
