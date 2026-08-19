package com.taoye.labor_dispatch.controller;

import com.taoye.labor_dispatch.config.ResultVo;
import com.taoye.labor_dispatch.entity.dto.OrderDetailDto;
import com.taoye.labor_dispatch.entity.vo.OrderDetailVo;
import com.taoye.labor_dispatch.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author (taoye)
 * @version V1.0
 * @ClassName: OrderDetailController
 * @Description: 订单详情
 * @date 2026-08-19
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/add")
    public ResultVo add(@RequestBody OrderDetailDto dto) {
        orderDetailService.save(dto);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo<List<OrderDetailVo>> list(@RequestBody OrderDetailDto dto) {
        List<OrderDetailVo> list = orderDetailService.list(dto);
        return ResultVo.success(list);
    }

    @PostMapping("/count")
    public ResultVo count(@RequestBody OrderDetailDto dto) {
        Integer vo = orderDetailService.count(dto);
        return ResultVo.success(vo);
    }

    @PostMapping("/update")
    public ResultVo update(@RequestBody OrderDetailDto dto) {
        orderDetailService.update(dto);
        return ResultVo.success();
    }

    @PostMapping("/delete")
    public ResultVo delete(@RequestBody OrderDetailDto dto) {
        orderDetailService.delete(dto);
        return ResultVo.success();
    }

}
