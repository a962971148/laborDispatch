package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.dto.UpstreamLaborCompanyDto;
import com.taoye.labor_dispatch.entity.vo.UpstreamLaborCompanyVo;
import com.taoye.labor_dispatch.service.UpstreamLaborCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: UpstreamLaborCompanyController
 * @Description: 上游劳务公司
 * @date 2026-08-19
 */
@RestController
@RequestMapping("/upstreamLaborCompany")
public class UpstreamLaborCompanyController {

    @Autowired
    UpstreamLaborCompanyService upstreamLaborCompanyService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody UpstreamLaborCompanyDto dto) {
        upstreamLaborCompanyService.save(dto);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo<List<UpstreamLaborCompanyVo>> list(@RequestBody UpstreamLaborCompanyDto dto) {
        List<UpstreamLaborCompanyVo> list = upstreamLaborCompanyService.list(dto);
        return ResultVo.success(list);
    }

    @PostMapping("/count")
    public ResultVo count(@RequestBody UpstreamLaborCompanyDto dto) {
        Integer vo = upstreamLaborCompanyService.count(dto);
        return ResultVo.success(vo);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody UpstreamLaborCompanyDto dto) {
        upstreamLaborCompanyService.update(dto);
        return ResultVo.success();
    }

    @PostMapping("/delete")
    public ResultVo delete(@RequestBody UpstreamLaborCompanyDto dto) {
        upstreamLaborCompanyService.delete(dto);
        return ResultVo.success();
    }

}
