package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.controller.vo.FormVo;
import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.service.OrderService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    /**
     * TODO: 开启分页
     */

    @Resource
    private OrderService tableDataService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Result<TableVo> tableData(@RequestParam int page, int limit) {
        return tableDataService.putInOrder(page, limit);
    }

    @RequestMapping(value = "/order/data", method = RequestMethod.GET)
    public Result<TableVo> tableSearchData(@RequestParam String goodsName, int page, int limit) {
        return tableDataService.putInOrderByGoodsName(goodsName, page, limit);
    }

    @RequestMapping(value = "/order/type", method = RequestMethod.GET)
    public Result<TableVo> tableType(@RequestParam int type, int page, int limit) {
        return tableDataService.putInOrderByType(type, page, limit);
    }
    
    @RequestMapping(value = "/order/state", method = RequestMethod.GET)
    public Result<TableVo> tableState(@RequestParam int state, int page, int limit) {
        return tableDataService.putInOrderByState(state, page, limit);
    }

    @RequestMapping(value = "/order/newOrder", method = RequestMethod.POST)
    public Result<Object> from(FormVo formVo) {
        return tableDataService.newOrder(formVo);
    }
}