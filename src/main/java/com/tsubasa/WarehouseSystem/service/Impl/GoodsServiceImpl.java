package com.tsubasa.WarehouseSystem.service.Impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tsubasa.WarehouseSystem.dao.GoodsDao;
import com.tsubasa.WarehouseSystem.entity.Goods;
import com.tsubasa.WarehouseSystem.service.GoodsService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public Result<Goods> getAll(int page, int limit) {
        Page<Goods> orderPage = new Page<Goods>(page, limit);
        IPage<Goods> iPage = goodsDao.selectPage(orderPage, null);
        return new Result<>(iPage.getRecords(), 0, "", iPage.getTotal());
    }
    @Override
    public Result<Goods> selectByName(int page, int limit, String name) {
        Page<Goods> orderPage = new Page<Goods>(page, limit);
        IPage<Goods> iPage = goodsDao.selectPage(orderPage, new QueryWrapper<Goods>().eq("goods_name", name));
        return new Result<>(iPage.getRecords(), 0, "", iPage.getTotal());
    }
    @Override
    public Result<Object> delete(Goods goods) {
        goodsDao.deleteById(goods.getGoodsId());
        return new Result<>(null, 0, "", 0);
    }
    @Override
    public Result<Object> update(Goods goods) {
        goodsDao.insert(goods);
        return new Result<>(null, 0, "", 0);
    }
    @Override
    public Result<Object> insert(Goods goods) {
        goodsDao.insert(goods);
        return new Result<>(null, 0, "", 0);
    }
}