package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.dto.TagInfoDto;
import com.taoye.labor_dispatch.entity.dto.UserInfoDto;
import com.taoye.labor_dispatch.entity.vo.TagInfoVo;
import com.taoye.labor_dispatch.service.TagInfoService;
import com.taoye.labor_dispatch.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: TagInfoController 
 * @Description: TODO() 
 * @date 2026-04-17 18:53
 */
@RestController
@RequestMapping("/tagInfo")
public class TagInfoController {

    @Autowired
    TagInfoService tagInfoService;

    @PostMapping("/list")
    public ResultVo list(@RequestBody TagInfoDto tagInfoDto) {
        List<TagInfoVo> tagInfoVoList = tagInfoService.list(tagInfoDto);
        return ResultVo.success(tagInfoVoList);
    }
}
