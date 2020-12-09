package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("db_customer")
public class Customer {
    @TableId
    private int customerId;
    private String customerName;
    private String customerPhone;
}