package com.tsubasa.WarehouseSystem.service;

import java.util.List;

import com.tsubasa.WarehouseSystem.controller.vo.TableVo;

public interface TableDataService {
    public List<TableVo> putInOrder();
}