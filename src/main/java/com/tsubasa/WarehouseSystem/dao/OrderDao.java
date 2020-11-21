package com.tsubasa.WarehouseSystem.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tsubasa.WarehouseSystem.entity.Order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao extends BaseMapper<Order> {
    @Select("select * from db_order where order_type = ${orderType}")
    public List<Order> selectByType(@Param("orderType") int orderType);

    @Select("select * from db_order where is_order = ${orderState}")
    public List<Order> selectByIsOrder(int orderState);
}