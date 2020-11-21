package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface TableVoService {
    public Result<TableVo> putInOrderByType(int orderType);
    public Result<TableVo> putInOrder();
    public Result<TableVo> putInOrderByState(int orderState);
}