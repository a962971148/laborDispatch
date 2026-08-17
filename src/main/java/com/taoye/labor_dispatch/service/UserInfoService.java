package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.UserInfoDto;
import com.taoye.labor_dispatch.entity.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService {
    void save(UserInfoDto userInfoDto);

    Integer count(UserInfoDto userInfoDto);

    List<UserInfoVo> list(UserInfoDto userInfoDto);
}
