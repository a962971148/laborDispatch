package com.taoye.labor_dispatch.service.impl;

import com.taoye.labor_dispatch.entity.TagInfo;
import com.taoye.labor_dispatch.entity.TagUserInfoRef;
import com.taoye.labor_dispatch.entity.UserInfo;
import com.taoye.labor_dispatch.entity.dto.UserInfoDto;
import com.taoye.labor_dispatch.entity.vo.UserInfoVo;
import com.taoye.labor_dispatch.mapper.TagInfoMapper;
import com.taoye.labor_dispatch.mapper.TagUserInfoRefMapper;
import com.taoye.labor_dispatch.mapper.UserInfoMapper;
import com.taoye.labor_dispatch.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: UserInfoServiceImpl 
 * @Description: TODO() 
 * @date 2026-04-15 14:50
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    TagUserInfoRefMapper tagUserInfoRefMapper;

    @Autowired
    TagInfoMapper tagInfoMapper;


    @Override
    @Transactional
    public void save(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userInfoDto.getUserName());
        userInfo.setWechatNumber(userInfoDto.getWechatNumber());
        userInfo.setPhone(userInfoDto.getPhone());
        userInfo.setAge(userInfoDto.getAge());
        userInfo.setGender(userInfoDto.getGender());
        userInfo.setPositionIntention(userInfoDto.getPositionIntention());
        userInfo.setNativePlace(userInfoDto.getNativePlace());
        userInfo.setIntentionLevel(userInfoDto.getIntentionLevel());
        userInfo.setWorkAttitude(userInfoDto.getWorkAttitude());
        userInfo.setRemark(userInfoDto.getRemark());
        userInfoMapper.insertSelective(userInfo);
        if(!CollectionUtils.isEmpty(userInfoDto.getRemarkList())){
            userInfoDto.getRemarkList().forEach(item ->{
                TagInfo tagInfo = tagInfoMapper.query(item);
                if(!Objects.isNull(tagInfo)){
                    TagUserInfoRef tagUserInfoRef = new TagUserInfoRef();
                    tagUserInfoRef.setTagCode(tagInfo.getTagCode());
                    tagUserInfoRef.setUserInfoId(userInfo.getId());
                    tagUserInfoRefMapper.insertSelective(tagUserInfoRef);
                }
            });
        }
    }

    @Override
    public Integer count(UserInfoDto userInfoDto) {
        Integer count = userInfoMapper.count(userInfoDto);
        return count;
    }

    @Override
    public List<UserInfoVo> list(UserInfoDto userInfoDto) {
        List<UserInfoVo> list = userInfoMapper.query(userInfoDto);
        list.forEach(item ->{
            List<String> list1 =  tagInfoMapper.selectByUser(item.getId());
            item.setTagNameList(list1);
        });
        return list;
    }
}
