package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "db_orders")
public class Order {
    @TableId
    private int orderId;
    private String goodsName;
    private int goodsNum;
    private String orderDate;
    private int orderType;
    private String orderUser;
    private int orderPrice;
}