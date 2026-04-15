package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.entity.IntialDescription;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;
import com.taoye.labor_dispatch.mapper.IntialDescriptionMapper;
import com.taoye.labor_dispatch.service.IntialDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: IntialDescriptionServiceImpl 
 * @Description: TODO() 
 * @date 2026-04-14 19:15
 */
@Service
public class IntialDescriptionServiceImpl implements IntialDescriptionService {

    @Autowired
    IntialDescriptionMapper intialDescriptionMapper;

    @Override
    public void save(IntialDescription intialDescription) {
        intialDescriptionMapper.insertSelective(intialDescription);
    }

    @Override
    public List<IntialDescriptionVo> list(IntialDescriptionDto dto) {
        List<IntialDescriptionVo> vo =  intialDescriptionMapper.query(dto);
        return vo;
    }
}
