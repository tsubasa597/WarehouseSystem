package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.FormVo;
import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface OrderService {
    public Result<TableVo> putInOrderByType(int orderType, int page, int limit);
    public Result<TableVo> putInOrder(int page, int limit);
    public Result<TableVo> putInOrderByState(int orderState, int page, int limit);
    public Result<TableVo> putInOrderByGoodsName(String goodsName, int page, int limit);
    public Result<Object> newOrder(FormVo formVo);
}