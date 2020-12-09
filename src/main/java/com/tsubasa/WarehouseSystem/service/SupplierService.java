package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.controller.vo.SupplierTableVo;
import com.tsubasa.WarehouseSystem.util.Result;

public interface SupplierService {
    public Result<SupplierTableVo> getAll(int page, int limit);
    public Result<Object> deleteSupplierById(int id);
    public Result<SupplierTableVo> selectSupplierByName(int page, int limit, String name);
    public Result<Object> updateSupplier(SupplierTableVo tableVo);
    public Result<Object> insertSupplier(SupplierTableVo tableVo);
}