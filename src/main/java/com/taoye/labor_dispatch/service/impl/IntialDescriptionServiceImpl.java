package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.config.IsDeleteEnum;
import com.taoye.labor_dispatch.entity.IntialDescription;
import com.taoye.labor_dispatch.entity.TagDescriptionRef;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;
import com.taoye.labor_dispatch.mapper.IntialDescriptionMapper;
import com.taoye.labor_dispatch.mapper.TagDescriptionRefMapper;
import com.taoye.labor_dispatch.mapper.TagInfoMapper;
import com.taoye.labor_dispatch.service.IntialDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    TagDescriptionRefMapper tagDescriptionRefMapper;

    @Autowired
    TagInfoMapper tagInfoMapper;

    @Override
    public void save(IntialDescriptionDto dto) {
        IntialDescription intialDescription = new IntialDescription();
        intialDescription.setIntialDescription(dto.getIntialDescription());
        intialDescription.setWechatNumber(dto.getWechatNumber());
        intialDescription.setGroupAffiliation(dto.getGroupAffiliation());
        intialDescriptionMapper.insertSelective(intialDescription);
        if(!CollectionUtils.isEmpty(dto.getTagInfoList())){
            dto.getTagInfoList().forEach(item ->{
                TagDescriptionRef tagDescriptionRef = new TagDescriptionRef();
                tagDescriptionRef.setIntialDescriptionId(intialDescription.getId());
                tagDescriptionRef.setTagCode(item);
                tagDescriptionRefMapper.insertSelective(tagDescriptionRef);
            });
        }
    }

    @Override
    public List<IntialDescriptionVo> list(IntialDescriptionDto dto) {
        dto.setIsDelete(IsDeleteEnum.NORMAL.getCode());

        if(!CollectionUtils.isEmpty(dto.getTagInfoList())){
            List<Long> ids = tagDescriptionRefMapper.queryByCodeList(dto.getTagInfoList());
            if(CollectionUtils.isEmpty(ids)){
                return null;

            };
            dto.setIds(ids);
        }
        List<IntialDescriptionVo> vo =  intialDescriptionMapper.query(dto);
        vo.forEach(item ->{
           List<String> tagList =  tagInfoMapper.selectByDes(item.getId());
           List<String> tagCodeList = tagInfoMapper.selectCodeByDes(item.getId());
           item.setTagInfoList(tagCodeList);
           item.setTagNameList(tagList);
        });
        return vo;
    }

    @Override
    public Integer count(IntialDescriptionDto intialDescriptionDto) {
        intialDescriptionDto.setIsDelete(IsDeleteEnum.NORMAL.getCode());
        Integer integer = intialDescriptionMapper.queryCount(intialDescriptionDto);
        return integer;
    }

    @Override
    public void update(IntialDescriptionDto dto) {
        tagDescriptionRefMapper.deleteByDes(dto.getId());

        IntialDescription intialDescription = new IntialDescription();
        intialDescription.setId(dto.getId());
        intialDescription.setIntialDescription(dto.getIntialDescription());
        intialDescription.setWechatNumber(dto.getWechatNumber());
//        intialDescription.setRemark(dto.);
        intialDescription.setGroupAffiliation(dto.getGroupAffiliation());
        intialDescriptionMapper.updateByPrimaryKeySelective(intialDescription);
        if(!CollectionUtils.isEmpty(dto.getTagInfoList())){
            dto.getTagInfoList().forEach(item ->{
                TagDescriptionRef tagDescriptionRef = new TagDescriptionRef();
                tagDescriptionRef.setIntialDescriptionId(intialDescription.getId());
                tagDescriptionRef.setTagCode(item);
                tagDescriptionRefMapper.insertSelective(tagDescriptionRef);
            });
        }
    }

    @Override
    public void delete(IntialDescriptionDto dto) {
        IntialDescription intialDescription = new IntialDescription();
        intialDescription.setId(dto.getId());
        intialDescription.setIsDelete(IsDeleteEnum.DELETED.getCode());
        intialDescriptionMapper.updateByPrimaryKeySelective(intialDescription);
    }
}
