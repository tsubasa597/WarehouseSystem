package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.tsubasa.WarehouseSystem.controller.vo.OrderFormVo;
import com.tsubasa.WarehouseSystem.controller.vo.OrderTableVo;
import com.tsubasa.WarehouseSystem.service.OrderService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    /**
     * TODO: 鉴权
     */

    @Resource
    private OrderService tableDataService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<OrderTableVo> select(@RequestParam int page, int limit) {
        return tableDataService.selectOrder(page, limit);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Result<OrderTableVo> selectByGoodsName(@RequestParam String goodsName, int page, int limit) {
        return tableDataService.selectOrderByGoodsName(goodsName, page, limit);
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public Result<OrderTableVo> selectByType(@RequestParam int type, int page, int limit) {
        return tableDataService.selectOrderByType(type, page, limit);
    }

    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    public Result<Object> insertOrder(OrderFormVo formVo, HttpSession httpSession) {
        formVo.setOrderUser(httpSession.getAttribute("name").toString()); 
        return tableDataService.insertOrder(formVo);
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public Result<Object> deleteOrderById(@RequestParam int id) {
        return tableDataService.deleteOrderById(id);
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public Result<Object> updateOrderById(OrderTableVo tableVo) {
        return tableDataService.updateOrderById(tableVo);
    }
}