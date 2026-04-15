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

import javax.annotation.Resource;
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
    public ResultVo add(@RequestBody IntialDescription intialDescription) {
        intialDescriptionService.save(intialDescription);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo<List<IntialDescriptionVo>> list(@RequestBody IntialDescriptionDto dto) {
        List<IntialDescriptionVo> list = intialDescriptionService.list(dto);
        return ResultVo.success(list);
    }


}
