package com.tsubasa.WarehouseSystem.service.api;

import java.util.List;

import com.tsubasa.WarehouseSystem.vo.TableVo;

public interface TableData {
    public List<TableVo> inWarehouseOrder();
    public List<TableVo> outWarehouseOrder();
}