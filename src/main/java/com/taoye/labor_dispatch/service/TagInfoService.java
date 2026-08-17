package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.TagInfoDto;
import com.taoye.labor_dispatch.entity.vo.TagInfoVo;

import java.util.List;

public interface TagInfoService {
    List<TagInfoVo> list(TagInfoDto tagInfoDto);
}
