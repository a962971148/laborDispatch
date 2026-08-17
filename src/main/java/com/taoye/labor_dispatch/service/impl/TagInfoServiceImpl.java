package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.entity.dto.TagInfoDto;
import com.taoye.labor_dispatch.entity.vo.TagInfoVo;
import com.taoye.labor_dispatch.mapper.TagInfoMapper;
import com.taoye.labor_dispatch.service.TagInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: TagInfoServiceImpl 
 * @Description: TODO() 
 * @date 2026-04-17 18:54
 */
@Service
public class TagInfoServiceImpl implements TagInfoService{

    @Autowired
    TagInfoMapper tagInfoMapper;

    @Override
    public List<TagInfoVo> list(TagInfoDto tagInfoDto) {
        List<TagInfoVo> tagInfoVoList = tagInfoMapper.queryList(tagInfoDto);
        return tagInfoVoList;
    }
}
