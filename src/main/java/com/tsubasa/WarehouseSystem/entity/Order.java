package com.tsubasa.WarehouseSystem.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName(value = "db_order")
public class Order {
    @TableId
    private int orderId;
    private String goodsName;
    private int goodsNum;
    private Date orderStartDate;
    private Date orderEndDate;
    private Boolean isOrder;
    private int orderType;
}