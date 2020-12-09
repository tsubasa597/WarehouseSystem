package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("db_supplier")
public class Supplier {
    @TableId
    private int supplierId;
    private String supplierName;
    private String supplierPhone;
}