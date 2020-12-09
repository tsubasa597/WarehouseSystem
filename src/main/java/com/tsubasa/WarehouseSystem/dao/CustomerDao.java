package com.tsubasa.WarehouseSystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsubasa.WarehouseSystem.entity.Customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao extends BaseMapper<Customer> {
    
}