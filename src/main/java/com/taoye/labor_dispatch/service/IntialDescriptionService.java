package com.taoye.labor_dispatch.service;

import com.taoye.labor_dispatch.entity.IntialDescription;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IntialDescriptionService {
    void save(IntialDescriptionDto intialDescription);

    List<IntialDescriptionVo> list(IntialDescriptionDto dto);

    Integer count(IntialDescriptionDto intialDescriptionDto);

    void update(IntialDescriptionDto dto);

    void delete(IntialDescriptionDto dto);
}
