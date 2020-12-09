package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.OrderFormVo;
import com.tsubasa.WarehouseSystem.controller.vo.OrderTableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface OrderService {
    public Result<OrderTableVo> selectOrderByType(int orderType, int page, int limit);
    public Result<OrderTableVo> selectOrder(int page, int limit);
    public Result<OrderTableVo> selectOrderByState(int orderState, int page, int limit);
    public Result<OrderTableVo> selectOrderByGoodsName(String goodsName, int page, int limit);
    public Result<Object> insertOrder(OrderFormVo formVo);
    public Result<Object> deleteOrderById(int id);
    public Result<Object> updateOrderById(OrderTableVo tableVo);
}