package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.IntialDescription;
import com.taoye.labor_dispatch.entity.dto.IntialDescriptionDto;
import com.taoye.labor_dispatch.entity.vo.IntialDescriptionVo;
import com.taoye.labor_dispatch.service.IntialDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @author (taoye)  
 * @version V1.0 
 * @ClassName: IntialDescritionController 
 * @Description: TODO() 
 * @date 2026-04-14 19:11
 */
@RestController
@RequestMapping("/intialDescrition")
public class IntialDescritionController {

    @Autowired
    IntialDescriptionService intialDescriptionService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody IntialDescriptionDto dto) {
        intialDescriptionService.save(dto);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo<List<IntialDescriptionVo>> list(@RequestBody IntialDescriptionDto dto) {
        List<IntialDescriptionVo> list = intialDescriptionService.list(dto);
        return ResultVo.success(list);
    }

    @PostMapping("/count")
    public ResultVo count(@RequestBody IntialDescriptionDto intialDescriptionDto) {
        Integer vo = intialDescriptionService.count(intialDescriptionDto);
        return ResultVo.success(vo);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody IntialDescriptionDto dto) {
        intialDescriptionService.update(dto);
        return ResultVo.success();
    }

    @PostMapping("/delete")
    public ResultVo delete(@RequestBody IntialDescriptionDto dto) {
        intialDescriptionService.delete(dto);
        return ResultVo.success();
    }



}
