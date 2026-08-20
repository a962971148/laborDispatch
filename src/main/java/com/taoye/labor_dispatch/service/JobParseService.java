package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;

public interface JobParseService {
    public IntialDescriptionVo parseJobInfo(String  req);
}
