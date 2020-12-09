package com.tsubasa.WarehouseSystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsubasa.WarehouseSystem.entity.Supplier;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierDao extends BaseMapper<Supplier> {
    
}