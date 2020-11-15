package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface TableVoService {
    public Result<TableVo> putInOrder();
}