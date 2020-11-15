package com.tsubasa.WarehouseSystem.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("db_goods")
public class Goods {
    @TableId
    private int goodsId;
    private String goodsName;
    private int goodsNum;
}