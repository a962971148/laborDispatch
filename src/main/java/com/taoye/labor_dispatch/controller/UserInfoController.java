package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.IntialDescription;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.dto.UserInfoDto;
import com.taoye.labor_dispatch.entity.vo.UserInfoVo;
import com.taoye.labor_dispatch.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: UserInfoController 
 * @Description: TODO() 
 * @date 2026-04-15 14:49
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody UserInfoDto userInfoDto) {
        userInfoService.save(userInfoDto);
        return ResultVo.success();
    }

    @PostMapping("/count")
    public ResultVo count(@RequestBody UserInfoDto userInfoDto) {
        Integer vo = userInfoService.count(userInfoDto);
        return ResultVo.success(vo);
    }


    @PostMapping("/list")
    public ResultVo list(@RequestBody UserInfoDto userInfoDto) {
        List<UserInfoVo> list = userInfoService.list(userInfoDto);
        return ResultVo.success(list);
    }

}
