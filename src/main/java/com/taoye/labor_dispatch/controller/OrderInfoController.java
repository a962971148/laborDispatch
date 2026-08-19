package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.dto.OrderInfoDto;
import com.taoye.labor_dispatch.entity.vo.OrderInfoVo;
import com.taoye.labor_dispatch.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderInfoController
 * @Description: 订单
 * @date 2026-08-19
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody OrderInfoDto dto) {
        orderInfoService.save(dto);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo<List<OrderInfoVo>> list(@RequestBody OrderInfoDto dto) {
        List<OrderInfoVo> list = orderInfoService.list(dto);
        return ResultVo.success(list);
    }

    @PostMapping("/count")
    public ResultVo count(@RequestBody OrderInfoDto dto) {
        Integer vo = orderInfoService.count(dto);
        return ResultVo.success(vo);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody OrderInfoDto dto) {
        orderInfoService.update(dto);
        return ResultVo.success();
    }

    @PostMapping("/delete")
    public ResultVo delete(@RequestBody OrderInfoDto dto) {
        orderInfoService.delete(dto);
        return ResultVo.success();
    }

    /**
     * 新建订单（关联多个订单详情）
     */
    @PostMapping("/addWithDetails")
    public ResultVo addWithDetails(@RequestBody OrderInfoDto dto) {
        orderInfoService.saveWithDetails(dto);
        return ResultVo.success();
    }

    /**
     * 查询订单（带关联的订单详情列表）
     */
    @PostMapping("/listWithDetails")
    public ResultVo<List<OrderInfoVo>> listWithDetails(@RequestBody OrderInfoDto dto) {
        List<OrderInfoVo> list = orderInfoService.listWithDetails(dto);
        return ResultVo.success(list);
    }

}
