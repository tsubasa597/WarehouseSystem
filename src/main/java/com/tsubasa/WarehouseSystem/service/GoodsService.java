package com.tsubasa.WarehouseSystem.service;

import com.tsubasa.WarehouseSystem.entity.Goods;
import com.tsubasa.WarehouseSystem.util.Result;

public interface GoodsService {
    public Result<Goods> getAll(int page, int limit);
    public Result<Goods> selectByName(int page, int limit, String name);
    public Result<Object> delete(Goods goods);
    public Result<Object> insert(Goods goods);
    public Result<Object> update(Goods goods);
}