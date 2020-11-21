package com.tsubasa.WarehouseSystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsubasa.WarehouseSystem.entity.Goods;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao extends BaseMapper<Goods> {
    
}