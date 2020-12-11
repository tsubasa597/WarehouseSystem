package com.tsubasa.WarehouseSystem.controller.api;

import javax.annotation.Resource;

import com.tsubasa.WarehouseSystem.entity.Goods;
import com.tsubasa.WarehouseSystem.service.GoodsService;
import com.tsubasa.WarehouseSystem.util.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<Goods> getAll(@RequestParam int page, int limit) {
        return goodsService.getAll(page, limit);
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Result<Goods> selectByName(@RequestParam int page, int limit, String name) {
        return goodsService.selectByName(page, limit, name);
    }

    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    public Result<Object> deleteGoods(Goods goods) {
        return goodsService.delete(goods);
    }

    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    public Result<Object> updateGoods(Goods goods) {
        return goodsService.update(goods);
    }

    @RequestMapping(value = "/insertGoods", method = RequestMethod.POST)
    public Result<Object> insertGoods(Goods goods) {
        return goodsService.insert(goods);
    }
}